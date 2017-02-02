
import com.web.dao.UsermessDAO;
import com.web.entity.Usermess;
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
public class UsermessTest {

    @Autowired
    private UsermessDAO usermessDAO;

    @Test
    public void insertUsermess()
    {
        Usermess usermess=new Usermess();
        usermess.setUser_id(2);
        usermess.setRealname_flag(1);
        usermess.setPicture("1.jpg");
        usermess.setUsername("aaa");
        usermess.setLove_count(100);
        usermess.setAge(12);
        usermess.setSex(1);
        usermess.setTelephone("1234567");
        usermess.setAccount_balance(1000.02);
        int flag=usermessDAO.insertUsermess(usermess);
        System.out.println(flag);
    }

    @Test
    public void selectUsermessFromId()
    {
        Usermess usermess=usermessDAO.selectUsermessFromId(1);
        System.out.println(usermess.getLove_count()+" "+usermess.getTelephone());
    }

    @Test
    public void updateUsermess()
    {
        Usermess usermess=new Usermess();
        usermess.setId(4);
        usermess.setUser_id(1);
        usermess.setRealname_flag(1);
        usermess.setPicture("4.jpg");
        usermess.setUsername("SSS");
        usermess.setLove_count(5);
        usermess.setAge(6);
        usermess.setSex(0);
        usermess.setTelephone("8");
        usermess.setAccount_balance(9);
        int flag=usermessDAO.updateUsermess(usermess);
        System.out.println(flag);
    }

    @Test
    public void deleteUsermess()
    {
        int flag=usermessDAO.deleteUsermess(3);
        System.out.println(3);
    }

    @Test
    public void selectUsermess()
    {
        Usermess usermess=new Usermess();
//        usermess.setRealname_flag(1);
//        usermess.setUsername("3");
//        usermess.setEmail("4");
//        usermess.setLove_count(5);
//        usermess.setAge(6);
        usermess.setSex(1);
//        usermess.setTelephone("8");
        List<Usermess> list=usermessDAO.selectUsermess(usermess,0,2);
        for(Usermess u:list){
            System.out.println(u.getId());
        }
    }
}
