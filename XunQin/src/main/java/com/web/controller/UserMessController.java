package com.web.controller;

import com.web.entity.Letter;
import com.web.entity.Lostmess;
import com.web.entity.Lostrecord;
import com.web.entity.Usermess;
import com.web.service.LetterService;
import com.web.service.LostActionService;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyi on 2016/12/16.
 * 用户个人主页
 */

@Controller("UserMessController")
@RequestMapping("/u/{uid}")
public class UserMessController {

    @Autowired
    private LostActionService lostActionService;

    @Autowired
    private LetterService letterService;

    @Autowired
    private UserService userService;

        //个人设置
        //usermess     用户基本信息页面
        //account      账户信息
        //realmess     实名认证

        //用户个人首页
        //myrecord     我的发布(已发布的寻亲启示)
        //mynews       我的留言(私信)


    //已发布的寻亲记录
    @RequestMapping("lostrecord")
    public ModelAndView viewLostrecord(HttpServletRequest request)
    {
        int size=3;
        int MaxPage=0;
        int nowPage=1;
        ModelAndView mav=new ModelAndView("myrecord");
        List<Lostrecord> lostrecordList=null;
        List<Lostmess> lostmessList=new ArrayList<Lostmess>();
        if(request.getParameter("nowpage")!=null && request.getParameter("nowpage")!=""){
            nowPage=Integer.parseInt(request.getParameter("nowpage"));
        }
        if(request.getSession().getAttribute("userid")!=null) {
            int id = (Integer) request.getSession().getAttribute("userid");
            lostrecordList=lostActionService.getLostrecordById(id,(nowPage-1)*size,size);
            if(lostrecordList.size()!=0) {
                for(Lostrecord lost:lostrecordList)
                {
                    Lostmess lostmess=new Lostmess();
                    lostmess=lostActionService.getLostmessFromId(lost.getLost_id());
                    lostmessList.add(lostmess);
                }
            }
            int max=lostActionService.getLostrecordMaxPage(id);
            MaxPage=max%size==0 ? max/size : max/size+1;
        }
        mav.addObject("NowPage",nowPage);
        mav.addObject("Lostrecord",lostrecordList);
        mav.addObject("Lostmess",lostmessList);
        mav.addObject("MaxPage",MaxPage);
        return mav;
    }

    //私信(收到的私信)
    @RequestMapping("letter")
    public ModelAndView letter(HttpServletRequest request)
    {
        int size=3;
        int MaxPage=0;
        int nowPage=1;
        ModelAndView mav=new ModelAndView("mynews");
        List<Letter> letters=null;
        List<Usermess> usermesses=new ArrayList<Usermess>();
        if(request.getParameter("nowpage")!=null && request.getParameter("nowpage")!=""){
            nowPage=Integer.parseInt(request.getParameter("nowpage"));
        }
        if(request.getSession().getAttribute("userid")!=null) {
            int id = (Integer) request.getSession().getAttribute("userid");
            letters=letterService.getLetterById(id,(nowPage-1)*size,size);
            if(letters.size()!=0) {
                for(Letter letter:letters)
                {
                    Usermess usermess=new Usermess();
                    usermess=userService.getUserMessByUserId(letter.getFromuser_id());
                    usermesses.add(usermess);
                }
            }
            int max=letterService.getMaxPage(id);
            MaxPage=max%size==0 ? max/size : max/size+1;
        }
        mav.addObject("NowPage",nowPage);
        mav.addObject("Letter",letters);
        mav.addObject("Usermess",usermesses);
        mav.addObject("MaxPage",MaxPage);
        return mav;
    }

    //发布留言
    @RequestMapping("addLetter")
    @ResponseBody
    public boolean addLetter(HttpServletRequest request)
    {
        boolean flag=false;
        if(request.getParameter("text")!=null && request.getParameter("text")!=""
               && request.getSession().getAttribute("userid")!=null) {
            int id = (Integer) request.getSession().getAttribute("userid");
            String mess=request.getParameter("text");
            flag=letterService.addLetter(mess,id);
        }
        return flag;
    }

    //资料库
    @RequestMapping("finddata")
    public void findData()
    {

    }

    //个人留言
    @RequestMapping("messboard")
    public void messBoard()
    {

    }

    //通知
    @RequestMapping("notices")
    public void notices()
    {

    }

    //寻亲启事
    @RequestMapping("actionlostmess")
    public void actionLostMess()
    {

    }

    //资料库
    @RequestMapping("actiondata")
    public void actionFindData()
    {

    }

    //通知
    @RequestMapping("actionnotices")
    public void actionNotices()
    {

    }

    //私信
    @RequestMapping("actionletter")
    public void actionletter()
    {

    }

    //通知设置
    @RequestMapping("setnotices")
    public void setnotices()
    {

    }

    //私信设置
    @RequestMapping("setletter")
    public void setLetter()
    {

    }

}
