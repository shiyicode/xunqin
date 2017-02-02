
import com.web.dao.GaminrecordDAO;
import com.web.entity.Gaminrecord;
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
public class GaminrecordTest {

    @Autowired
    private GaminrecordDAO gaminrecordDAO;

    @Test
    public void insertGaminrecord()
    {
        Gaminrecord gaminrecord=new Gaminrecord();
        gaminrecord.setGamin_id(1);
        gaminrecord.setUser_id(2);
        gaminrecord.setFind_status(1);
        gaminrecord.setPubdate("1000-04-10 10:40:40");
        int flag=gaminrecordDAO.insertGaminrecord(gaminrecord);
        System.out.println(flag);
    }

    @Test
    public void selectGaminrecordFromId()
    {
        Gaminrecord gaminrecord=gaminrecordDAO.selectGaminrecordFromId(2);
        System.out.println(gaminrecord.getFind_status()+" "+gaminrecord.getUser_id());
    }

    @Test
    public void updateGaminrecord()
    {
        Gaminrecord gaminrecord=new Gaminrecord();
        gaminrecord.setId(2);
        gaminrecord.setGamin_id(2);
        gaminrecord.setUser_id(2);
        gaminrecord.setFind_status(2);
        gaminrecord.setPubdate("1000-04-10 10:40:40");
        int flag=gaminrecordDAO.updateGaminrecord(gaminrecord);
        System.out.println(flag);
    }

    @Test
    public void deleteGaminrecord()
    {
        int flag=gaminrecordDAO.deleteGaminrecord(3);
        System.out.println(flag);
    }

    @Test
    public void selectGaminrecord()
    {
        Gaminrecord gaminrecord=new Gaminrecord();
        gaminrecord.setGamin_id(1);
        //gaminrecord.setUser_id(2);
        //gaminrecord.setFind_status(2);
        //gaminrecord.setPubdate("1000-04-10 10:40:40");
        List<Gaminrecord> list=gaminrecordDAO.selectGaminrecord(gaminrecord,0,2);
        for(Gaminrecord g:list){
            System.out.println(g.getId());
        }
    }
}
