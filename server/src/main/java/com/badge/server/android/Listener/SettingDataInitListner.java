package com.badge.server.android.Listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.HashSet;

@Component
class SettingDataInitListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("=====Servlet Initialization====");
        //  ApplicationContext -> WebApplicationContext
        WebApplicationContext webApplicationContext =
                (WebApplicationContext)contextRefreshedEvent.getApplicationContext();
        // get servletContext from webApplicationContext
        ServletContext servletContext = webApplicationContext.getServletContext();
        // initialization state
        servletContext.setAttribute("badge", new HashMap<String,Long>());
//        servletContext.setAttribute("dataset", new HashMap<String,Integer>());
        servletContext.setAttribute("badgePrevState", new HashMap<String,Integer>());
    }
}