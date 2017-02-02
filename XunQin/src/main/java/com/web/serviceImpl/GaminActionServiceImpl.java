package com.web.serviceImpl;

import com.web.dao.GaminmessDAO;
import com.web.dao.GaminrecordDAO;
import com.web.entity.Gaminmess;
import com.web.entity.Gaminrecord;
import com.web.service.GaminActionService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shiyi on 2016/12/19.
 */
@Service("GaminActionService")
public class GaminActionServiceImpl implements GaminActionService {

    @Autowired
    private GaminmessDAO gaminmessDAO;
    @Autowired
    private GaminrecordDAO gaminrecordDAO;

    public int getGaminMessCount() {

        return gaminmessDAO.selectGaminmessCount();
    }

    public List getGaminMess(int start, int num) {

        return gaminmessDAO.selectGaminmess(new Gaminmess(), start, num);
    }

    public Gaminmess getGaminMessById(int id) {

        return gaminmessDAO.selectGaminmessFromId(id);
    }

    public ServletFileUpload getFileData() {


        DiskFileItemFactory dff = new DiskFileItemFactory();
        dff.setSizeThreshold(1024000);
        ServletFileUpload sfu = new ServletFileUpload(dff);
        sfu.setFileSizeMax(1024*1024*2);
        return sfu;
    }


    public String uploadGaminMess(List<FileItem> uploaditems, String path) {

        String load = "";
        Iterator<FileItem> item = uploaditems.iterator();
        while (item.hasNext()) {

            FileItem fi = (FileItem) item.next();
            String fileName = fi.getName();

            if (fileName != null) {

                File fullFile = null;
                try {
                    fullFile = new File(new String(fi.getName().getBytes(), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                File file = new File(path, fullFile.getName());
                load = "/picture/" + fullFile.getName();
                try {
                    fi.write(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return load;

    }

    public boolean addGaminMess(String find_time, int age, int sex, int height, String find_place, String feature, String picture_list, String other_message, int user_id) {

        boolean result = false;
        Gaminmess gaminmess = new Gaminmess();
        if(find_time.equals("null")){
            gaminmess.setFind_time(null);
        }else{
            gaminmess.setFind_time(find_time);
        }
        gaminmess.setAge(age);
        gaminmess.setSex(sex);
        gaminmess.setHeight(height);
        gaminmess.setFind_place(find_place);
        gaminmess.setFeature(feature);

        if(picture_list.equals(null)) {
            gaminmess.setPicture_list(null);
        }else{
            gaminmess.setPicture_list(picture_list);
        }
        gaminmess.setOther_message(other_message);
        gaminmessDAO.insertGaminmess(gaminmess);
        int lost_id = gaminmess.getId();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pubdate = formats.format(cal.getTime());
        Gaminrecord gaminrecord = new Gaminrecord();

        gaminrecord.setGamin_id(lost_id);
        gaminrecord.setUser_id(user_id);
        gaminrecord.setFind_status(0);      //0：未找到　１：找到
        gaminrecord.setPubdate(pubdate);
        gaminrecordDAO.insertGaminrecord(gaminrecord);
        result = true;

        return result;
    }


    public boolean updateGaminMess(int id, String find_time, int age, int sex, int height, String find_place, String feature, String picture_list, String other_message) {

        boolean result = false;
        Gaminmess gaminmess = new Gaminmess();
        if(find_time.equals("null")){
            gaminmess.setFind_time(null);
        }else{
            gaminmess.setFind_time(find_time);
        }
        gaminmess.setId(id);
        gaminmess.setAge(age);
        gaminmess.setSex(sex);
        gaminmess.setHeight(height);
        gaminmess.setFind_place(find_place);
        gaminmess.setFeature(feature);

        if(picture_list.equals(null)) {
            gaminmess.setPicture_list(null);
        }else{
            gaminmess.setPicture_list(picture_list);
        }
        gaminmess.setOther_message(other_message);
        gaminmessDAO.updateGaminmess(gaminmess);
        Gaminrecord gaminrecord = new Gaminrecord();
        gaminrecord.setGamin_id(id);
        List<Gaminrecord> list = gaminrecordDAO.selectGaminrecord(gaminrecord, 0, 1);
        int gaminrecord_id = 0;
        int user_id = 0;
        int find_status = 0;
        for(Gaminrecord gaminrecord1 : list) {

            gaminrecord_id = gaminrecord1.getId();
            user_id = gaminrecord1.getUser_id();
            find_status = gaminrecord1.getFind_status();

        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pubdate = formats.format(cal.getTime());
        Gaminrecord gaminrecord2 = new Gaminrecord();
        gaminrecord2.setId(gaminrecord_id);
        gaminrecord2.setGamin_id(id);
        gaminrecord2.setUser_id(user_id);
        gaminrecord2.setFind_status(find_status); //0：未找到　１：找到
        gaminrecord2.setPubdate(pubdate);
        gaminrecordDAO.updateGaminrecord(gaminrecord2);
        result = true;


        return result;
    }

}