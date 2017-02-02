
import com.web.dao.BlogmainDAO;
import com.web.entity.Blogmain;
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
public class BlogmainTest {

    @Autowired
    private BlogmainDAO blogmainDAO;

    @Test
    public void insertblogmain()
    {
        Blogmain blogmain=new Blogmain();
        blogmain.setUser_id(1);
        blogmain.setTitle("aaaaa");
        blogmain.setContent("bbbb");
        blogmain.setCreatedate("1000-04-10 10:40:40");
        blogmain.setHeart_num(12);
        int flag=blogmainDAO.insertBlogmain(blogmain);
        System.out.println(flag);
    }

    @Test
    public void selectblogmainFromId()
    {
        Blogmain blogmain=blogmainDAO.selectBlogmainFromId(2);
        System.out.println(blogmain.getHeart_num()+" "+blogmain.getTitle());
    }

    @Test
    public void updateblogmain()
    {
        Blogmain blogmain=new Blogmain();
        blogmain.setId(2);
        blogmain.setUser_id(1);
        blogmain.setTitle("2");
        blogmain.setContent("3");
        blogmain.setCreatedate("1000-04-10 10:40:40");
        blogmain.setHeart_num(4);
        int flag=blogmainDAO.updateBlogmain(blogmain);
        System.out.println(flag);
    }

    @Test
    public void deleteblogmain()
    {
        int flag=blogmainDAO.deleteBlogmain(3);
        System.out.println(flag);
    }

    @Test
    public void selectBlogmain()
    {

        Blogmain blogmain=new Blogmain();
        //blogmain.setUser_id(1);
        //blogmain.setTitle("a");
        //blogmain.setCreatedate("1000-04-10");
        blogmain.setHeart_num(12);
        List<Blogmain> list=blogmainDAO.selectBlogmain(blogmain,2,2);
        for(Blogmain u:list){
            System.out.println(u.getId());
        }
    }
}
