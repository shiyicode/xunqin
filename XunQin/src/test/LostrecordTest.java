
import com.web.dao.LostrecordDAO;
import com.web.entity.Lostrecord;
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
public class LostrecordTest {

    @Autowired
    private LostrecordDAO lostrecordDAO;

    @Test
    public void insertLostrecord()
    {
        Lostrecord findlost=new Lostrecord();
        findlost.setLost_id(2);
        findlost.setUser_id(1);
        findlost.setFind_status(2);
        findlost.setPubdate("1000-04-10 10:40:40");
        int flag=lostrecordDAO.insertLostrecord(findlost);
        System.out.println(flag);
    }

    @Test
    public void selectLostrecordFromId()
    {
        Lostrecord findlost=lostrecordDAO.selectLostrecordFromId(2);
        System.out.println(findlost.getLost_id()+" "+findlost.getPubdate());
    }

    @Test
    public void updateLostrecord()
    {
        Lostrecord findlost=new Lostrecord();
        findlost.setId(2);
        findlost.setLost_id(2);
        findlost.setUser_id(2);
        findlost.setFind_status(2);
        findlost.setPubdate("1000-04-10 10:40:40");
        int flag=lostrecordDAO.updateLostrecord(findlost);
        System.out.println(flag);
    }

    @Test
    public void deleteLostrecord()
    {
        int flag=lostrecordDAO.deleteLostrecord(3);
        System.out.println(flag);
    }

    @Test
    public void selectGaminrecord()
    {
        Lostrecord findlost=new Lostrecord();
//        findlost.setLost_id(2);
//        findlost.setUser_id(2);
        findlost.setFind_status(2);
//        findlost.setPubdate("1000-04-10 10:40:40");
        List<Lostrecord> list=lostrecordDAO.selectLostrecord(findlost,0,2);
        for(Lostrecord g:list){
            System.out.println(g.getId());
        }
    }

    @Test
    public void selectCountFromId()
    {
        int result=lostrecordDAO.selectCountFromId(2);
        System.out.println(result);
    }
}
