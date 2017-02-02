package com.web.serviceImpl;

import com.web.dao.UserDAO;
import com.web.dao.UsermessDAO;
import com.web.entity.*;
import com.web.service.UserService;
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
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UsermessDAO usermessDAO;


    public int login(String email, String password, String number, String code) {
        User user = new User();
        user.setEmail(email);

        List<User> userlist = userDAO.selectUser(user, 0, 1);


        if(userlist.size() == 0)
        {
            //用户名不存在
            return 1;
        }

        User user1 = userlist.get(0);
        if(!user1.getPassword().equals(password))
        {
            //密码错误
            return 2;
        }else {
            return 0;
        }
    }

    public boolean isexist(String email) {
        boolean flag=false;
        User user=new User();
        user.setEmail(email);
        List<User> users=userDAO.selectUser(user,0,10);
        //可以进行注册
        if(users.size()==0){
            flag=true;
        }
        return flag;
    }

    public int insertuser(String email,String userpass){
        User user = new User();
        user.setEmail(email);
        user.setPassword(userpass);
        int flag1 = userDAO.insertUser(user);
        int userid=user.getId();
        Usermess usermess=new Usermess();
        usermess.setUser_id(userid);
        int flag2 = usermessDAO.insertUsermess(usermess);
        if(flag1!=1 || flag2!=1){
            if(flag1==1){
                userDAO.deleteUser(userid);
            }
            if(flag2==1){
                usermessDAO.deleteUsermess(usermess.getId());
            }
            return -1;
        }
        return userid;
    }

    public int getidbyemail(String email){
        User user=new User();
        user.setEmail(email);
        List<User> users=userDAO.selectUser(user,0,10);
        return users.get(0).getId();
    }
    public String upload(List<FileItem> uploaditems, String path) {

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
    public ServletFileUpload getFileData() {

        DiskFileItemFactory dff = new DiskFileItemFactory();
        dff.setSizeThreshold(1024000);
        ServletFileUpload sfu = new ServletFileUpload(dff);
        sfu.setFileSizeMax(1024*1024*2);
        return sfu;

    }
    public Usermess addUserMess(int userid,String name,String sex,String pic,String age)
    {
        Usermess usermess=new Usermess();
        usermess.setUser_id(userid);
        List<Usermess> list=usermessDAO.selectUsermess(usermess,0,1);
        if(list.size()!=0)
            usermess = list.get(0);
        if(name != null) {
            usermess.setUsername(name);
        }
        if (sex != null) {
            usermess.setSex(Integer.parseInt(sex));
        }
        if (pic != null) {
            usermess.setPicture(pic);
        }
        if (age != null) {
            usermess.setAge(Integer.parseInt(age));
        }
        if(list.size()!=0) {
            usermessDAO.updateUsermess(usermess);
        }

        return usermess;
    }

    public Usermess getUserMessByUserId(int userid)
    {
        Usermess user=null;
        if(userid>0)
        {
            Usermess usermess=new Usermess();
            usermess.setUser_id(userid);
            if((usermessDAO.selectUsermess(usermess,0,1)).size()!=0) {
                user=usermessDAO.selectUsermess(usermess, 0, 1).get(0);
            }
        }
        return user;
    }

}
