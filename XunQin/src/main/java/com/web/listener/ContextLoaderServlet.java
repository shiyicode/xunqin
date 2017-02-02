package com.web.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by shiyi on 16/9/26.
 */


@Component
public class ContextLoaderServlet implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        String path = sce.getServletContext().getRealPath("/");
        path += "/WEB-INF/static/picture";

        File folder = new File(path);
        if(!folder.exists() || !folder.isDirectory())
            folder.mkdir();

        ServletContext sct=sce.getServletContext();
        sct.setAttribute("pageViewCount", 987);
        System.out.println("begin:" + sct.getAttribute("pageViewCount"));

    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sct=sce.getServletContext();
        System.out.println("end:" + sct.getAttribute("pageViewCount"));
    }
}
