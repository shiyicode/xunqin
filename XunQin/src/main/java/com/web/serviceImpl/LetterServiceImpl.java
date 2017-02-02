package com.web.serviceImpl;

import com.web.dao.LetterDAO;
import com.web.dao.UserDAO;
import com.web.dao.UsermessDAO;
import com.web.entity.Letter;
import com.web.entity.User;
import com.web.entity.Usermess;
import com.web.service.LetterService;
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
@Service("LetterService")
public class LetterServiceImpl implements LetterService {

    @Autowired
    private LetterDAO letterDAO;

    @Autowired
    private UsermessDAO usermessDAO;

    public List<Letter> getLetterById(int userid, int start, int size) {
        Letter letter=new Letter();
        letter.setUser_id(userid);
        List<Letter> letters=letterDAO.selectLetter(letter,start,size);
        return letters;
    }

    public boolean addLetter(String mess,int fromid){
        //@xiaoming@qq.com:aaaaaaaaaa
        boolean flag=false;
        mess.trim();
        int from=mess.indexOf("@");
        int to=mess.indexOf(":");
        if(from!=-1 && to!=-1){
            String username=mess.substring(from+1,to);
            String message=mess.substring(to+1);
            int id=0;
            Usermess usermess=new Usermess();
            usermess.setUsername(username);
            List<Usermess> usermessList=usermessDAO.selectUsermess(usermess,0,1);
            if(usermessList.size()!=0){
                id=usermessList.get(0).getUser_id();
            }
            if(id!=0){
                Letter letter=new Letter();
                letter.setUser_id(id);
                letter.setFromuser_id(fromid);
                letter.setContent(message);
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String pubdate = formats.format(cal.getTime());
                letter.setCreatedate(pubdate);
                letter.setIsread_flag(1);
                int result=letterDAO.insertLetter(letter);
                if(result==1){
                    flag=true;
                }
            }
        }
        return flag;
    }

    public int getMaxPage(int userid){
        return letterDAO.selectCountFromId(userid);
    }
}
