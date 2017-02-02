import com.web.dao.RealmessDAO;
import com.web.entity.Realmess;
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
public class RealmessTest {

    @Autowired
    private RealmessDAO realmessDAO;

    @Test
    public void insertRealmess()
    {
        Realmess realmess=new Realmess();
        realmess.setUser_id(1);
        realmess.setReal_name("1234");
        realmess.setId_number("601729");
        realmess.setProvince_city("dgaj");
        realmess.setAddress("dhdakajdk");
        int flag=realmessDAO.insertRealmess(realmess);
        System.out.println(flag);
    }

    @Test
    public void selectRealmessFromId()
    {
        Realmess realmess=realmessDAO.selectRealmessFromId(1);
        System.out.println(realmess.getAddress()+" "+realmess.getUser_id()+" "+realmess.getId_number());
    }

    @Test
    public void updateRealmess()
    {
        Realmess realmess=new Realmess();
        realmess.setId(2);
        realmess.setUser_id(1);
        realmess.setReal_name("2");
        realmess.setId_number("3");
        realmess.setProvince_city("4");
        realmess.setAddress("5");
        int flag=realmessDAO.updateRealmess(realmess);
        System.out.println(flag);
    }

    @Test
    public void deleteRealmess()
    {
        int flag=realmessDAO.deleteRealmess(2);
        System.out.println(flag);
    }

    @Test
    public void selectRealmess()
    {
        Realmess realmess=new Realmess();
        realmess.setUser_id(1);
//        realmess.setReal_name("2");
//        realmess.setId_number("3");
//        realmess.setProvince_city("4");
        List<Realmess> list=realmessDAO.selectRealmess(realmess,0,2);
        for(Realmess r:list){
            System.out.println(r.getId());
        }
    }
}
