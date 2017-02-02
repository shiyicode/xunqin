
import com.web.dao.UserDAO;
import com.web.entity.User;
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
public class UserTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void insertUser()
    {
        User user=new User();
        user.setQq_id(111);
        user.setWx_id(222);
        user.setWb_id(333);
        user.setQq_number("1111");
        user.setWx_number("2222");
        user.setWb_number("3333");
        user.setIs_open(0);
        user.setEmail("shiyi@qq.com");
        user.setPassword("shiyi");
        int flag=userDAO.insertUser(user);
        System.out.println(flag);
    }

    @Test
    public void selectUserFromId()
    {
        User user=userDAO.selectUserFromId(3);
        System.out.println(user.getWb_number()+" "+user.getPassword()+" "+user.getIs_open());
    }

    @Test
    public void updateUser()
    {
        User user=new User();
        user.setId(1);
        user.setQq_id(2);
        user.setWx_id(3);
        user.setWb_id(4);
        user.setQq_number("5");
        user.setWx_number("6");
        user.setWb_number("7");
        user.setIs_open(8);
        user.setEmail("9");
        user.setPassword("10");
        int flag=userDAO.updateUser(user);
        System.out.println(flag);
    }

    @Test
    public void deleteUser()
    {
        int flag=userDAO.deleteUser(3);
        System.out.println(flag);
    }

    @Test
    public void selectUser()
    {
        User user=new User();
//        user.setUsermessage_id(1);
        user.setQq_id(2);
//        user.setWx_id(3);
//        user.setWb_id(4);
//        user.setIs_open(8);
//        user.setEmail("9");
        List<User> list=userDAO.selectUser(user,0,2);
        for(User u:list){
            System.out.println(u.getId());
        }
    }
}
