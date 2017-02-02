package com.web.service;

import com.web.entity.Lostmess;
import com.web.entity.Lostrecord;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.util.List;

/**
 * Created by shiyi on 2016/12/19.
 */
public interface LostActionService {

    //获取寻人启事数
    public int getLostMessCount(Lostmess lostmess);

    //获取寻人信息
    public List getLostMess(Lostmess lostmess, int start, int num);

    public Lostmess getLostMessById(int id);

    public Lostmess getLostMessByName(String name);


    public ServletFileUpload getFileData();


    public String uploadLostMess(List<FileItem> uploaditems, String path);

    public boolean addLostMess(String name, int sex, int height, String birthday, String native_place,
                               int blood_type, String lost_place, String lost_date, String picture_list,
                               String feature, int find_type, String other_message, String phone,
                               String email, int user_id);

    public boolean updateLostMess(int id, String name, int sex, int height, String birthday,
                                  String native_place, int blood_type, String lost_place,
                                  String lost_date, String picture_list, String feature,
                                  int find_type, String other_message, String phone, String email);

    public List<Lostrecord> getLostrecordById(int userid, int start, int size);

    public int getLostrecordMaxPage(int userid);

    public Lostmess getLostmessFromId(int id);
}
