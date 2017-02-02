package com.web.controller;

import com.web.entity.Usermess;
import com.web.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by shiyi on 2016/12/16.
 * 个人设置类
 */
@Controller("UserSetController")
@RequestMapping("/user")
public class UserSetController {

    @Autowired
    private UserService userService;

    @RequestMapping("/upload")
    public ModelAndView uploadLostMess(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ServletFileUpload sfu = userService.getFileData();
        List<FileItem> list = sfu.parseRequest(request);

        String path = request.getServletContext().getRealPath("/");
        path += "WEB-INF/static/images";
        String load = userService.upload(list, path);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(load);

        return null;

    }

    //基本信息
    @RequestMapping("setprofile")
    public ModelAndView viewSetprofile(HttpServletRequest request)
    {
        Usermess usermess=null;
        ModelAndView mav=new ModelAndView("usermess");

        String name=null;
        String sex=null;
        String pic=null;
        String age=null;
        String address=null;
        String fulladdress=null;
        if(request.getParameter("username")!=null && request.getParameter("username")!="") {
            name = request.getParameter("username");
        }
        if(request.getParameter("usersex")!=null && request.getParameter("usersex")!="") {
            sex = request.getParameter("usersex");
        }
        if(request.getParameter("idfrontpic")!=null && request.getParameter("idfrontpic")!="") {
            pic = request.getParameter("idfrontpic");
        }
        if(request.getParameter("userage")!=null && request.getParameter("userage")!="") {
            age = request.getParameter("userage");
        }
        if(request.getParameter("s_province")!=null && request.getParameter("s_province")!="") {
            address = request.getParameter("s_province") + request.getParameter("s_city") + request.getParameter("s_county");
        }
        if(request.getParameter("useraddress")!=null && request.getParameter("useraddress")!="") {
            fulladdress = request.getParameter("useraddress");
        }
        if(request.getSession().getAttribute("userid")!=null) {
            int id=(Integer)request.getSession().getAttribute("userid");
            usermess = userService.addUserMess(id,name, sex, pic, age);
            request.getSession().setAttribute("UserMess",usermess);
        }
        mav.addObject("Usermess",usermess);
        return mav;
    }

    //帐号绑定
    @RequestMapping("setbindsns")
    public void viewSetBindsns()
    {

    }

    //收货地址
    @RequestMapping("setaddress")
    public void viewSetAddress()
    {

    }

    //实名认证
    @RequestMapping("setrealmess")
    public void viewSetRealMess()
    {

    }

    //更改基本信息
    @RequestMapping("ajaxprofile")
    public void ajaxSetprofile()
    {

    }

    //更改帐号绑定
    @RequestMapping("ajaxbindsns")
    public void ajaxSetBindsns()
    {

    }

    //更改收货地址
    @RequestMapping("ajaxaddress")
    public void ajaxSetAddress()
    {

    }

    //更改实名认证
    @RequestMapping("ajaxrealmess")
    public void ajaxSetRealMess()
    {

    }

}
