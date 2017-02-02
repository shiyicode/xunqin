
import com.web.dao.BlogleaveDAO;
import com.web.entity.Blogleave;
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
public class BlogleaveTest {

    @Autowired
    private BlogleaveDAO blogleaveDAO;

    @Test
    public void insertblogleave()
    {
        Blogleave blogleave=new Blogleave();
        blogleave.setFloor_id(2);
        blogleave.setLeave_id(1);
        blogleave.setReceive_id(3);
        blogleave.setMain_id(1);
        blogleave.setLeave_content("dddd");
        blogleave.setCreatedate("1000-04-10 10:40:40");
        blogleave.setHeart_num(13);
        int flag=blogleaveDAO.insertBlogleave(blogleave);
        System.out.println(flag);
    }

    @Test
    public void selectblogleaveFromId()
    {
        Blogleave blogleave=blogleaveDAO.selectBlogleaveFromId(2);
        System.out.println(blogleave.getHeart_num()+" "+blogleave.getLeave_content());
    }

    @Test
    public void updateblogleave()
    {
        Blogleave blogleave=new Blogleave();
        blogleave.setId(2);
        blogleave.setFloor_id(1);
        blogleave.setLeave_id(2);
        blogleave.setReceive_id(3);
        blogleave.setMain_id(4);
        blogleave.setLeave_content("5");
        blogleave.setCreatedate("1000-04-10 10:40:40");
        blogleave.setHeart_num(6);
        int flag=blogleaveDAO.updateBlogleave(blogleave);
        System.out.println(flag);
    }

    @Test
    public void deleteblogleave()
    {
        int flag=blogleaveDAO.deleteBlogleave(3);
        System.out.println(flag);
    }

    @Test
    public void selectblogleave()
    {

        Blogleave blogleave=new Blogleave();
//        blogleave.setFloor_id(2);
        blogleave.setLeave_id(1);
//        blogleave.setReceive_id(1);
//        blogleave.setMain_id(1);
//        blogleave.setCreatedate("1000-04-10 10:40:40");
//        blogleave.setHeart_num(13);
        List<Blogleave> list=blogleaveDAO.selectBlogleave(blogleave,0,2);
        for(Blogleave u:list){
            System.out.println(u.getId());
        }
    }
}
