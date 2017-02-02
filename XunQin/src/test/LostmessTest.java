import com.web.dao.LostmessDAO;
import com.web.entity.Lostmess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by shiyi on 16/9/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-MVC.xml"
        ,"classpath:config/spring-mybatis.xml"})
public class LostmessTest {

    @Autowired
    private LostmessDAO lostmessDAO;

    @Test
    public void selectCount()
    {
        int a = lostmessDAO.selectLostmessCount(new Lostmess());
        System.out.println(a);
    }

    @Test
    public void insertLostmess()
    {
        Lostmess lostmess=new Lostmess();
        lostmess.setName("王三妃");
        lostmess.setSex(0);
        lostmess.setHeight(132);
        lostmess.setBirthday("1996-06-04 00:00:00");
        lostmess.setNative_place("陕西省西安市");
        lostmess.setBlood_type(1);
        lostmess.setLost_place("月球八里屯");
        lostmess.setLost_date("2016-12-25 20:20:20");
        lostmess.setPicture_list("images/child.jpg;images/111.jpg");
        lostmess.setFeature("蠢");
        lostmess.setFind_type(1);
        lostmess.setOther_message("无备注信息");
        int flag=lostmessDAO.insertLostmess(lostmess);
        System.out.println(flag);
    }

    @Test
    public void selectLostmessFromId()
    {
        Lostmess lostmess=lostmessDAO.selectLostmessFromId(2);
        System.out.println(lostmess.getBlood_type()+" "+lostmess.getOther_message());
    }

    @Test
    public void updateLostmess()
    {
        Lostmess lostmess=new Lostmess();
        lostmess.setId(2);
        lostmess.setName("1");
        lostmess.setSex(2);
        lostmess.setHeight(3);
        lostmess.setBirthday("2000-02-20 20:20:20");
        lostmess.setNative_place("4");
        lostmess.setBlood_type(5);
        lostmess.setLost_place("6");
        lostmess.setLost_date("2000-02-20 20:20:20");
        lostmess.setPicture_list("7");
        lostmess.setFeature("8");
        lostmess.setFind_type(9);
        lostmess.setOther_message("10");
        int flag=lostmessDAO.updateLostmess(lostmess);
        System.out.println(flag);
    }

    @Test
    public void deleteLostmess()
    {
        int flag=lostmessDAO.deleteLostmess(3);
        System.out.println(flag);
    }

    @Test
    public void selectLostmess()
    {
        Lostmess lostmess=new Lostmess();
//        lostmess.setName("bbc");
        lostmess.setSex(1);
//        lostmess.setHeight(177);
//        lostmess.setBirthday("2000-02-20 20:20:20");
//        lostmess.setNative_place("aaaa");
//        lostmess.setBlood_type(2);
//        lostmess.setLost_place("asd");
//        lostmess.setLost_date("2000-02-20 20:20:20");
//        lostmess.setPicture_list("1.jpg");
//        lostmess.setFeature("aaaaa");
//        lostmess.setFind_type(1);
//        lostmess.setOther_message("aaaaaaaaaaaaaa");
        List<Lostmess> list=lostmessDAO.selectLostmess(lostmess,3,3);
        for(Lostmess l:list){
            System.out.println(l.getId());
        }
    }
}
