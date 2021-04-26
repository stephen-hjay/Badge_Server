package com.badge.server.frontend.Controller;


import com.badge.server.GlobalParameters;
import com.badge.server.android.Entity.Pojo.Badge;
import com.badge.server.android.Entity.Pojo.Movement;
import com.badge.server.android.Entity.Pojo.Voice;
import com.badge.server.android.Entity.analysis.ActiveRecord;
import com.badge.server.android.Entity.analysis.MovementState;
import com.badge.server.frontend.entity.pojo.DatasetStatFrontEnd;
import com.badge.server.frontend.entity.pojo.NearMacsFrontEnd;
import com.badge.server.frontend.entity.pojo.NearPhoneFrontEnd;
import com.badge.server.frontend.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RequestMapping("/badge")
@RestController
public class BadgeController {
    @Autowired
    private BadgeService badgeService;


    /**
     * find badges by dataset id
     * @param dataset_id
     * @return
     */
    @GetMapping("/badges")
    public List<Badge> getAll(@PathParam("dataset_id") String dataset_id) {
        return  badgeService.getAll(dataset_id);
    }
    @GetMapping("/movement")
    public List<Movement> getMovments(@PathParam("badge_id") String badge_id, @PathParam("dataFrom") String dataFrom, @PathParam("dataTo") String dataTo) {
        if (dataFrom==null && dataTo==null){
            return badgeService.getMovement(badge_id);
        }else {
            if (dataFrom == null){
                return badgeService.getMovement(badge_id, null, Long.parseLong(dataTo));
            }else if(dataTo==null){
                return badgeService.getMovement(badge_id,Long.parseLong(dataFrom),null);
            }else{
                return badgeService.getMovement(badge_id,Long.parseLong(dataFrom),Long.parseLong(dataTo));
            }
        }
    }
    @GetMapping("/movementstate")
    public List<MovementState> getMovmentState(@PathParam("badge_id") String badge_id, @PathParam("dataFrom") String dataFrom, @PathParam("dataTo") String dataTo) {
        if (dataFrom==null && dataTo==null){
            return badgeService.getMovementState(badge_id);
        }else {
            if (dataFrom == null){
                return badgeService.getMovementState(badge_id, null, Long.parseLong(dataTo));
            }else if(dataTo==null){
                return badgeService.getMovementState(badge_id,Long.parseLong(dataFrom),null);
            }else{
                return badgeService.getMovementState(badge_id,Long.parseLong(dataFrom),Long.parseLong(dataTo));
            }
        }
    }

    @GetMapping("/voice")
    public List<Voice> getVoices(@PathParam("badge_id") String badge_id, @PathParam("dataFrom") String dataFrom, @PathParam("dataTo") String dataTo) {
        if (dataFrom==null && dataTo==null){
            return badgeService.getVoice(badge_id);
        }else {
            if (dataFrom == null){
                return badgeService.getVoice(badge_id, null, Long.parseLong(dataTo));
            }else if(dataTo==null){
                return badgeService.getVoice(badge_id,Long.parseLong(dataFrom),null);
            }else{
                return badgeService.getVoice(badge_id,Long.parseLong(dataFrom),Long.parseLong(dataTo));
            }
        }
    }

    @GetMapping("/nearmac")
    public NearMacsFrontEnd getNearMacs(@PathParam("badge_id") String badge_id){
        return badgeService.getNearMacs(badge_id);
    }

    /**
     * NearPhoneFrontEnd :
     String badgeid;

     String datasetid;

     long timestamp;

     List<String> nearAddress;

     * @param badge_id, dataset_id
     * @return list of NearPhoneEnd according to badge_id
     */
    @GetMapping("/nearphone")
    public List<NearPhoneFrontEnd> getNearPhone(@PathParam("badge_id") String badge_id, @PathParam("dataset_id") String dataset_id){
        return badgeService.getNearPhones(badge_id,dataset_id);
    }

    @GetMapping("/activephone")
    public List<String> getActivePhone(HttpSession httpSession){
        ServletContext servletContext = httpSession.getServletContext();
        Map<String,Long> onlineBadges = (Map<String, Long>) servletContext.getAttribute("badge");
        List<String> activeBadgeList = new ArrayList<>();
        long currentTime = System.currentTimeMillis();
        for (String badgeid :onlineBadges.keySet()){
            if (currentTime - onlineBadges.get(badgeid)<= GlobalParameters.timeout){
                activeBadgeList.add(badgeid);
            }else{
                onlineBadges.remove(badgeid);
            }
        }
        return activeBadgeList;
    }

    @GetMapping("/activehistory")
    public DatasetStatFrontEnd getActiveHistory(@PathParam("dataset_id") String dataset_id,
                                                @PathParam("dataFrom") String dataFrom, @PathParam("dataTo") String dataTo){

        if (dataFrom==null && dataTo==null){
            return badgeService.getActiveHistory(dataset_id);
        }else {
            if (dataFrom == null){
                return badgeService.getActiveHistory(dataset_id,null,Long.parseLong(dataTo));
            }else if(dataTo==null){
                return badgeService.getActiveHistory(dataset_id,Long.parseLong(dataFrom),null);
            }else{
                return badgeService.getActiveHistory(dataset_id,Long.parseLong(dataFrom),Long.parseLong(dataTo));
            }
        }
    }

}