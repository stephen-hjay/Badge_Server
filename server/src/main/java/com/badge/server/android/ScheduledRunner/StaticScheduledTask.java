package com.badge.server.android.ScheduledRunner;


import com.badge.server.GlobalParameters;
import com.badge.server.android.DAO.BadgeRepository;
import com.badge.server.frontend.DAO.DatasetRepository;
import com.badge.server.frontend.DAO.DatasetStatRepository;
import com.badge.server.frontend.entity.pojo.DatasetStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class StaticScheduledTask {

    @Autowired
    BadgeRepository badgeRepository;

    @Autowired
    DatasetStatRepository datasetStatRepository;

    @Autowired
    private ServletContext servletContext;

    //3.添加定时任务
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate=GlobalParameters.persistTime)
    private void configureTasks() {

        if (servletContext != null){
//            System.out.println("dataset online stat");
            Map<String,Long> onlineBadges = (Map<String, Long>) servletContext.getAttribute("badge");
//            System.out.println(onlineBadges);
            Map<String, Integer> datasetStatMap = new HashMap<>();
            if (onlineBadges!=null){
                for (String badgeid : onlineBadges.keySet()) {
                    String datasetId = badgeRepository.findDatasetByBadgeid(badgeid);
//                System.out.println(datasetId);
                    datasetStatMap.put(datasetId, datasetStatMap.getOrDefault(datasetId, 0) + 1);
                }
//            System.out.println(datasetStatMap);
//            List<DatasetStat> datasetStatList = new ArrayList<>();
                // persistence
                for (String datasetid : datasetStatMap.keySet()){
                    DatasetStat datasetStat = new DatasetStat();
                    datasetStat.setDatasetid(datasetid);
                    datasetStat.setNum(datasetStatMap.get(datasetid));
                    datasetStat.setTimestamp(System.currentTimeMillis());
                    datasetStatRepository.save(datasetStat);
                }
            }
        }
    }
}
