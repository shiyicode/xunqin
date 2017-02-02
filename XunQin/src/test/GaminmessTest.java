import com.web.dao.GaminmessDAO;
import com.web.entity.Gaminmess;
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
public class GaminmessTest {

    @Autowired
    private GaminmessDAO gaminmessDAO;

    @Test
    public void selectCount()
    {
        int a = gaminmessDAO.selectGaminmessCount();
        System.out.println(a);
    }

    @Test
    public void insertGaminmess()
    {
        Gaminmess gaminmess=new Gaminmess();
        gaminmess.setFind_time("1000-04-10 10:40:40");
        gaminmess.setAge(12);
        gaminmess.setSex(1);
        gaminmess.setHeight(180);
        gaminmess.setFind_place("aaa");
        gaminmess.setFeature("aaaaa");
        gaminmess.setPicture_list("assssss");
        gaminmess.setOther_message("ssssss");
        int flag=gaminmessDAO.insertGaminmess(gaminmess);
        System.out.println(flag);
    }

    @Test
    public void selectGaminmessFromId()
    {
        Gaminmess gaminmess=gaminmessDAO.selectGaminmessFromId(2);
        System.out.println(gaminmess.getOther_message()+" "+gaminmess.getFind_place());
    }

    @Test
    public void updateGaminmess()
    {
        Gaminmess gaminmess=new Gaminmess();
        gaminmess.setId(2);
        gaminmess.setFind_time("1000-04-10 10:40:40");
        gaminmess.setAge(1);
        gaminmess.setSex(2);
        gaminmess.setHeight(3);
        gaminmess.setFind_place("4");
        gaminmess.setFeature("5");
        gaminmess.setPicture_list("6");
        gaminmess.setOther_message("7");
        int flag=gaminmessDAO.updateGaminmess(gaminmess);
        System.out.println(flag);
    }

    @Test
    public void deleteGaminmess()
    {
        int flag=gaminmessDAO.deleteGaminmess(3);
        System.out.println(flag);
    }

    @Test
    public void selectGaminmess()
    {
        Gaminmess gaminmess=new Gaminmess();
//        gaminmess.setFind_time("1000-04-10 10:40:40");
        gaminmess.setAge(1);
//        gaminmess.setSex(2);
        //gaminmess.setHeight(3);
        //gaminmess.setFind_place("4");
        List<Gaminmess> list=gaminmessDAO.selectGaminmess(gaminmess,0,2);
        for(Gaminmess g:list){
            System.out.println(g.getId());
        }
    }
}
