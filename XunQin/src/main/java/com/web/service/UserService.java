package com.web.service;

import com.web.entity.Lostrecord;
import com.web.entity.User;
import com.web.entity.Usermess;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.util.List;

/**
 * Created by Administrator on 2016/12/31 0031.
 */
public interface UserService {
    public boolean isexist(String email);
    public int insertuser(String email, String userpass);
    public int login(String email, String password, String number, String code);
    public int getidbyemail(String email);
    public String upload(List<FileItem> uploaditems, String path);
    public ServletFileUpload getFileData();
    public Usermess addUserMess(int userid, String name, String sex, String pic, String age);
    public Usermess getUserMessByUserId(int userid);
}
