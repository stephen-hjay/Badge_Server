package com.badge.server.android.Initalizer;

import com.badge.server.GlobalParameters;
import com.badge.server.frontend.DAO.DatasetRepository;
import com.badge.server.frontend.entity.pojo.Dataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
class SettingDataInitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    DatasetRepository datasetRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("=====Servlet Initialization====");
        //  ApplicationContext -> WebApplicationContext
        WebApplicationContext webApplicationContext =
                (WebApplicationContext)contextRefreshedEvent.getApplicationContext();
        // get servletContext from webApplicationContext
        ServletContext servletContext = webApplicationContext.getServletContext();
        // initialization state
       ConcurrentHashMap<String,Long> badge =  new ConcurrentHashMap<String,Long>();
        servletContext.setAttribute("badge",badge);
        ConcurrentHashMap<String,Integer> badgePrevState =  new ConcurrentHashMap<String,Integer>();
        servletContext.setAttribute("badgePrevState", badgePrevState);
        datasetStatInitializer(servletContext);
    }


    private void datasetStatInitializer(ServletContext servletContext){
        List<Dataset> datasetList = datasetRepository.findAll();
        ConcurrentHashMap<String, Integer> datasetStatMap = new ConcurrentHashMap<>();
        for (Dataset dataset:datasetList){
            datasetStatMap.put(dataset.getDatasetid(),0);
        }
        servletContext.setAttribute("datasets",datasetStatMap);
    }
}