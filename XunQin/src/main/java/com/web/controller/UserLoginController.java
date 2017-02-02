package com.web.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.web.entity.User;
import com.web.entity.Usermess;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by shiyi on 2016/12/16.
 * 登陆类
 */
@Controller("UserLoginController")
@RequestMapping("/goto")
public class UserLoginController {

    @Autowired
    private UserService userService;

    //检查cookie
    @RequestMapping("check")
    public ModelAndView checkCookie(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView("redirect:/home");
        String username=(String) request.getAttribute("username");
        String userpass=(String) request.getAttribute("userpass");

        System.out.println("checklogin"+username+userpass);

        HttpSession session=request.getSession();
        session.setAttribute("isCheck", true);

        if(username!=null && username!="" && userpass!=null && userpass!="")
        {
            int flag = userService.login(username, userpass, "1", "1");
            if(flag==0) {
                session.setAttribute("userid", userService.getidbyemail(username));
                if(userService.getidbyemail(username)>0) {
                    session.setAttribute("UserMess",userService.getUserMessByUserId(userService.getidbyemail(username)) );
                }
            }
        }
        return mav;
    }

    //用户登录
    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mav=new ModelAndView("login");
        String email=request.getParameter("username");
        String userpass=request.getParameter("userpass");
        String remember=request.getParameter("remember");
        HttpSession session=request.getSession();

        if (email!=null && email!="" && userpass!=null && userpass!="") {

            int flag = userService.login(email, userpass, "1", "1");
            System.out.println(flag);
            switch (flag) {
                case 0: {
                    if (remember != null && "1".equals(remember)) {
                        Cookie user = new Cookie("user", email + ":" + userpass);
                        user.setPath("/");
                        user.setMaxAge(7 * 24 * 60 * 60);
                        response.addCookie(user);
                    }
                    session.setAttribute("userid", userService.getidbyemail(email));
                    if(userService.getidbyemail(email)>0) {
                        session.setAttribute("UserMess",userService.getUserMessByUserId(userService.getidbyemail(email)) );
                    }
                    mav = new ModelAndView("redirect:/home");
                }
                break;
                case 1:
                    mav.addObject("error", "用户名不存在");
                    break;
                case 2:
                    mav.addObject("error", "密码错误");
                    break;
            }
        }
        return mav;
    }

    //用户名查重验证(ajax)
    @RequestMapping("isexist")
    public void check(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            PrintWriter out = response.getWriter();
            String email = request.getParameter("email");
            String result = "no";
            if (email != null && !email.equals("")) {
                if(userService.isexist(email)) {
                    result = "yes";
                }
            }
            System.out.println('E'+email);
            out.write(result);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    //注册
    @RequestMapping("register")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mav=new ModelAndView("register");
        String email=null;
        String userpass=null;
        if(request.getParameter("useremail") != null && request.getParameter("useremail")!=""
                &&
                request.getParameter("userpass") != null && request.getParameter("userpass") != "") {
            email = request.getParameter("useremail");
            userpass = request.getParameter("userpass");
            int num = userService.insertuser(email,userpass);
            if(num>0)
            {
                mav.addObject("mess",true);
                mav.addObject("num",num);
            }
            else
            {
                mav.addObject("mess", false);
            }
        }

        return mav;
    }

}
