package com.badge.server.android.ScheduledRunner;


import com.badge.server.GlobalParameters;
import com.badge.server.android.DAO.BadgeRepository;
import com.badge.server.frontend.DAO.DatasetStatRepository;
import com.badge.server.frontend.entity.pojo.DatasetStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import javax.servlet.ServletContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration      // component
@EnableScheduling   // enable scheduling
public class StaticScheduledTask {

    @Autowired
    BadgeRepository badgeRepository;

    @Autowired
    DatasetStatRepository datasetStatRepository;

    @Autowired
    private ServletContext servletContext;

    //3.scheduled task
    // interval = PERSIST_TIME
    @Scheduled(fixedRate=GlobalParameters.PERSIST_TIME)
    private void configureTasks() {
        if (servletContext != null){
                Map<String,Long> onlineBadges = (Map<String, Long>) servletContext.getAttribute("badge");
                Map<String, Integer> datasetStatMap = (Map<String, Integer>) servletContext.getAttribute("datasets");// use database no need to acquire lock
                // avoid null pointer exception
                if (onlineBadges!=null && datasetStatMap != null) {
                    // clear original records
                    for (String datasetid : datasetStatMap.keySet()) {
                        datasetStatMap.put(datasetid, 0);
                    }
                    // put the stat onto datasetStatMap
                    for (String badgeid : onlineBadges.keySet()) {
                        String datasetId = badgeRepository.findDatasetByBadgeid(badgeid);
                        datasetStatMap.put(datasetId, datasetStatMap.getOrDefault(datasetId, 0) + 1);
                    }
                    long currentime = System.currentTimeMillis();
                    // persistence
                    for (String datasetid : datasetStatMap.keySet()) {
                        DatasetStat datasetStat = new DatasetStat();
                        datasetStat.setDatasetid(datasetid);
                        datasetStat.setNum(datasetStatMap.get(datasetid));
                        datasetStat.setTimestamp(currentime);
                        datasetStatRepository.save(datasetStat);
                    }
                }
            }
        }
    }


