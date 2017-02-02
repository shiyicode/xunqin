
import com.web.dao.LetterDAO;
import com.web.entity.Letter;
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
public class LetterTest {

    @Autowired
    private LetterDAO letterDAO;

    @Test
    public void insertLetter()
    {
        Letter letter=new Letter();
        letter.setUser_id(1);
        letter.setFromuser_id(2);
        letter.setTitle("aaa");
        letter.setContent("hahahaah");
        letter.setCreatedate("2000-02-20 20:20:20");
        letter.setIsread_flag(0);
        int flag=letterDAO.insertLetter(letter);
        System.out.println(flag);
    }

    @Test
    public void selectLetterFromId()
    {
        Letter letter=letterDAO.selectLetterFromId(2);
        System.out.println(letter.getCreatedate()+" "+letter.getTitle());
    }

    @Test
    public void updateLetter()
    {
        Letter letter=new Letter();
        letter.setId(5);
        letter.setUser_id(1);
        letter.setFromuser_id(1);
        letter.setTitle("3");
        letter.setContent("4");
        letter.setCreatedate("2000-02-20 20:20:20");
        letter.setIsread_flag(5);
        int flag=letterDAO.updateLetter(letter);
        System.out.println(flag);
    }

    @Test
    public void deleteLetter()
    {
        int flag=letterDAO.deleteLetter(3);
        System.out.println(flag);
    }

    @Test
    public void selectLetter()
    {
        Letter letter=new Letter();
        letter.setUser_id(1);
        letter.setFromuser_id(2);
//        letter.setTitle("3");
//        letter.setCreatedate("2000-02-20 20:20:20");
        letter.setIsread_flag(5);
        List<Letter> list=letterDAO.selectLetter(letter,0,2);
        for(Letter l:list){
            System.out.println(l.getId());
        }
    }
    @Test
    public void selectCountFromId()
    {
        int result=letterDAO.selectCountFromId(2);
        System.out.println(result);
    }
}
