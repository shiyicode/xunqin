package com.web.controller;

import com.web.entity.Lostmess;
import com.web.entity.Usermess;
import com.web.service.GaminActionService;
import com.web.service.LostActionService;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by shiyi on 2016/12/18.
 */
@Controller("HomeController")
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private LostActionService lostActionService;
    @Autowired
    private GaminActionService gaminActionService;
    @Autowired
    private UserService userService;

    @RequestMapping("")
    public ModelAndView forwardHome(HttpServletRequest request){

        ServletContext servletContext = request.getServletContext();
        Object ob = servletContext.getAttribute("pageViewCount");
        Integer num = (Integer) ob + 1;
        System.out.println("访问人数 = " + num);
        servletContext.setAttribute("pageViewCount", num);

        ModelAndView mdv = new ModelAndView("home");
        System.out.println(num.intValue()+"num");
        mdv.addObject("pageViewCount", num.intValue());

        int dataNum = gaminActionService.getGaminMessCount();
        mdv.addObject("gaminMessCount", dataNum);

        int lostNum = lostActionService.getLostMessCount(new Lostmess());
        mdv.addObject("lostMessCount", lostNum);

        if(request.getSession().getAttribute("userid")!=null) {
            Usermess usermess = userService.getUserMessByUserId((Integer)request.getSession().getAttribute("userid"));
            mdv.addObject("Usermess",usermess);
        }

        System.out.println(lostNum);
        System.out.println(dataNum);

        return mdv;
    }
}
