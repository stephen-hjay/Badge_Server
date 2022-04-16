package com.badge.server.frontend.service.Impl;

import com.badge.server.android.DAO.*;
import com.badge.server.android.Entity.Pojo.Badge;
import com.badge.server.android.Entity.Pojo.Movement;
import com.badge.server.android.Entity.Pojo.Voice;
import com.badge.server.android.Entity.analysis.MovementState;
import com.badge.server.frontend.DAO.DatasetStatRepository;
import com.badge.server.frontend.entity.pojo.*;
import com.badge.server.frontend.service.BadgeService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BadgeServiceImpl implements BadgeService {

    @Autowired
    BadgeRepository badgeRepository;

    @Autowired
    MovementRepository movementRepository;

    @Autowired
    MovementStateRepository movementStateRepository;

    @Autowired
    VoiceRepository voiceRepository;

    @Autowired
    NearMacsRepository nearMacsRepository;

    @Autowired
    DatasetStatRepository datasetStatRepository;

    @Override
    public List<Badge> getAll(String dataset_id) {
        return badgeRepository.findAllByDatasetid(dataset_id);
    }

    @Override
    public List<Movement> getMovement(String badge_id) {
        return movementRepository.findAllByBadgeid(badge_id);
    }

    @Override
    public List<Movement> getMovement(String badge_id, Long dataFrom, Long dataTo) {
        // dataFrom ! =
        if (dataFrom != null && dataTo ==null){
            List<Movement> movementList = movementRepository.findAllByBadgeidAndTimestampGreaterThanEqual(badge_id, dataFrom);
            return movementList;
        }else if (dataFrom != null){
            List<Movement> movementList = movementRepository.findAllByBadgeidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(badge_id,dataFrom,dataTo);
            return movementList;
        }else{
            List<Movement> movementList = movementRepository.findAllByBadgeidAndTimestampLessThanEqual(badge_id, dataTo);
            return movementList;
        }
    }

    @Override
    public List<MovementState> getMovementState(String badge_id) {
        return movementStateRepository.findAllByBadgeid(badge_id);
    }

    @Override
    public List<MovementState> getMovementState(String badge_id, Long dataFrom, Long dataTo) {
        // dataFrom ! =
        if (dataFrom != null && dataTo ==null){
            List<MovementState> movementStatesList = movementStateRepository.findAllByBadgeidAndTimestampGreaterThanEqual(badge_id,dataFrom);
            return movementStatesList;
        }else if (dataFrom != null){
            List<MovementState> movementStatesList = movementStateRepository.findAllByBadgeidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(badge_id, dataFrom,dataTo);
            return movementStatesList;
        }else{
            List<MovementState> movementStatesList = movementStateRepository.findAllByBadgeidAndTimestampLessThanEqual(badge_id, dataTo);
            return movementStatesList;
        }
    }


    @Override
    public List<Voice> getVoice(String badge_id) {
        return voiceRepository.findAllByBadgeid(badge_id);
    }

    @Override
    public List<Voice> getVoice(String badge_id, Long dataFrom, Long dataTo) {
        if (dataFrom != null && dataTo == null) {
            List<Voice> voiceList = voiceRepository.findAllByBadgeidAndTimestampGreaterThanEqual(badge_id, dataFrom);
            return voiceList;
        } else if (dataFrom != null) {
            List<Voice> voiceList = voiceRepository.findAllByBadgeidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(badge_id,dataFrom, dataTo);
            return voiceList;
        } else {
            List<Voice> voiceList = voiceRepository.findAllByBadgeidAndTimestampLessThanEqual(badge_id, dataTo);
            return voiceList;
        }
    }

    @Override
    public NearMacsFrontEnd getNearMacs(String badge_id) {
        // 1. get timestamp
        List<Long> timestampList = nearMacsRepository.findTimeStamp(badge_id);
        NearMacsFrontEnd nearMacsFrontEnd = new NearMacsFrontEnd();
        // 2. loop the timestamp list to get the mac addresses belong to the time stamp
        for (long timestamp : timestampList){
            nearMacsFrontEnd.getListTimeStamp().add(timestamp);
            nearMacsFrontEnd.getListMacAddress().add(nearMacsRepository.findMacAddress(badge_id,timestamp));
        }
        return nearMacsFrontEnd;
    }

    @Override
    public List<NearPhoneFrontEnd> getNearPhones(String badge_id, String dataset_id){
        List<Long> timestampList = nearMacsRepository.findTimeStamp(badge_id);
        List<NearPhoneFrontEnd> nearPhoneFrontEndList = new ArrayList<>();
        // 2. loop the timestamp list to get the mac addresses belong to the time stamp
        for (long timestamp : timestampList){
            NearPhoneFrontEnd nearPhoneFrontEnd = new NearPhoneFrontEnd();
            nearPhoneFrontEnd.setBadgeid(badge_id);
            nearPhoneFrontEnd.setDatasetid(dataset_id);
            nearPhoneFrontEnd.setTimestamp(timestamp);
            nearPhoneFrontEnd.setNearAddress((nearMacsRepository.findMacAddress(badge_id,timestamp)));
            nearPhoneFrontEndList.add(nearPhoneFrontEnd);
        }
        return nearPhoneFrontEndList;
    }


    @Override
    public List<DatasetStatBar> getActiveHistory(String dataset_id, Long dataFrom, Long dataTo, int minute) {

        long interval = minute * 60 * 1000;

        int num_of_bar = (int) ((dataTo - dataFrom)/interval);

        List<DatasetStatBar> datasetStatBars = new ArrayList<>();

        for (int i=0; i<num_of_bar; i++){
            long dataFrom1 = dataFrom + i * interval;
            long dataTo1 = dataFrom + (i+1)* interval;
            Integer num = datasetStatRepository.findMaxByDatasetidAndTimestampAfterAndTimestampBefore(dataset_id,dataFrom1,dataTo1);
            DatasetStatBar datasetStatBar = new DatasetStatBar();
            datasetStatBar.setDatasetid(dataset_id);
            datasetStatBar.setMed((dataFrom1+dataTo1)/2);
            if (num!=null){
                datasetStatBar.setNum(num);
            }else{
                datasetStatBar.setNum(0);
            }
            datasetStatBars.add(datasetStatBar);
        }

        return datasetStatBars;
    }


    @Override
    public List<SpeechRatioBar> getSpeechRatio(String dataset_id, Long dataFrom, Long dataTo, int minute) {

        long interval = minute * 60 * 1000;
        int num_of_bar = (int) ((dataTo - dataFrom) / interval);
        System.out.println(num_of_bar);
        List<SpeechRatioBar> speechRatioBars = new ArrayList<>();
        for (int i = 0; i < num_of_bar; i++) {
            long dataFrom1 = dataFrom + i * interval;
            long dataTo1 = dataFrom + (i + 1) * interval;
            List<Map<String, Object>> queryResult = voiceRepository.findByCalculatingPower(dataset_id, dataFrom1, dataTo1);
            List<Pair<String,Double>> rawdataList = new ArrayList<>();
            SpeechRatioBar speechRatioBar = new SpeechRatioBar();

            double total_power = 0;
            // badgeid // power
            for (Map<String,Object> keyValPair: queryResult){
                String badgeid = "";
                double power = 1L;
                for (String key: keyValPair.keySet()){
                    if (key.equals("badgeid")){
                        badgeid = (String) keyValPair.get(key);
                    }else if (key.equals("power")){
                        power = (double) keyValPair.get(key);
                        total_power += power;
                    }
                }
                rawdataList.add(new Pair<>(badgeid,power));
            }
            speechRatioBar.setMed((dataFrom1+dataTo1)/2);
            ArrayList<Double> percentageList = new ArrayList<>();
            ArrayList<String> badgeIdList = new ArrayList<>();
            for (Pair<String,Double> rawdata : rawdataList){
                badgeIdList.add(rawdata.getKey());
                percentageList.add(rawdata.getValue()/total_power);
            }
            speechRatioBar.setDatasetId(dataset_id);
            speechRatioBar.setBadgeIdList(badgeIdList);
            speechRatioBar.setPercentageList(percentageList);
            speechRatioBars.add(speechRatioBar);
        }
        return speechRatioBars;
    }

    @Override
    public List<BadgeSpeechRatio> getSpeechRatio(String dataset_id, Long dataFrom, Long dataTo) {
        List<BadgeSpeechRatio> badgeSpeechRatioList = new ArrayList<>();
        List<Map<String,Object>> queryResult = voiceRepository.findFrequency("Nokia3",1619553107758L,1619553616316L);

        // badgeid // percentage
        for (Map<String,Object> keyValPair: queryResult){
            BadgeSpeechRatio badgeSpeechRatio = new BadgeSpeechRatio();
            String badgeid = "";
            double percentage = 0.0;
            for (String key: keyValPair.keySet()){
                if (key.equals("badgeid")){
                    badgeid = (String) keyValPair.get(key);
                    badgeSpeechRatio.setBadge_id(badgeid);
                }else if (key.equals("percentage")){
                    percentage = (double) keyValPair.get(key);
                    badgeSpeechRatio.setPercentage(percentage);
                }
            }
            badgeSpeechRatio.setDataFrom(dataFrom);
            badgeSpeechRatio.setDataTo(dataTo);
            badgeSpeechRatio.setDataset_id(dataset_id);
            badgeSpeechRatioList.add(badgeSpeechRatio);
        }

        return badgeSpeechRatioList;
    }

    @Override
    public List<BadgeMovementRatio> getMovementRatio(String dataset_id, Long dataFrom, Long dataTo) {
        //
        List<Map<String,Object>> badgeListMap = badgeRepository.findBadgesByDatasetId(dataset_id);
        List<String> badgeList = new ArrayList<>();

        for (Map<String,Object> badgeMap : badgeListMap){
            badgeList.add((String) badgeMap.get("id"));
        }
        List<BadgeMovementRatio> badgeMovementRatioList = new ArrayList<>();
        for (String badgeid : badgeList){
            Map<String,Object> queryResult = movementStateRepository.findBadgeSitPercentAndMovementPercent(badgeid,dataFrom,dataTo);

            Object sitpercent = queryResult.get("sitpercent");
            Object movepercent = queryResult.get("movepercent");
            if (sitpercent==null || movepercent==null){
                continue;
            }
//            double sitpercent = sitpercent;
//            double movepercent = (double) queryResult.get("movepercent");
            BadgeMovementRatio badgeMovementRatio = new BadgeMovementRatio();
            badgeMovementRatio.setBadge_id(badgeid);
            badgeMovementRatio.setDataset_id(dataset_id);
            System.out.println(movepercent);
            badgeMovementRatio.setMovementPercent((BigDecimal) movepercent);
            badgeMovementRatio.setSitPercent((BigDecimal) sitpercent);
            badgeMovementRatioList.add(badgeMovementRatio);
        }
        return badgeMovementRatioList;
    }


    @Override
    public DatasetStatFrontEnd getActiveHistory(String dataset_id, int minute) {
        DatasetStatFrontEnd datasetStatFrontEnd = new DatasetStatFrontEnd();
        List<DatasetStat> datasetStatList = datasetStatRepository.findAllByDatasetid(dataset_id);
        datasetStatFrontEndHelper(datasetStatFrontEnd,datasetStatList,dataset_id);
        return datasetStatFrontEnd;
    }


    private void datasetStatFrontEndHelper(DatasetStatFrontEnd datasetStatFrontEnd, List<DatasetStat> datasetStatList, String datasetid){
        datasetStatFrontEnd.setDatasetid(datasetid);
        ArrayList<Integer> stats = new ArrayList<>();
        ArrayList<Long> timestamps = new ArrayList<>();
//        System.out.println("======================="+datasetStatList);
        for(DatasetStat datasetStat : datasetStatList){
            stats.add(datasetStat.getNum());
            timestamps.add(datasetStat.getTimestamp());
        }
        datasetStatFrontEnd.setNums(stats);
        datasetStatFrontEnd.setTimestamps(timestamps);
    }
    public DatasetStatFrontEnd getActiveHistoryHelper(String dataset_id, Long dataFrom, Long dataTo) {
        DatasetStatFrontEnd datasetStatFrontEnd = new DatasetStatFrontEnd();
        if (dataFrom != null && dataTo == null) {
            List<DatasetStat> datasetStatList = datasetStatRepository.findAllByDatasetidAndTimestampGreaterThanEqual(dataset_id,dataFrom);
            datasetStatFrontEndHelper(datasetStatFrontEnd,datasetStatList,dataset_id);
            return datasetStatFrontEnd;
        } else if (dataFrom != null) {
            List<DatasetStat> datasetStatList = datasetStatRepository.findAllByDatasetidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(dataset_id,dataFrom,dataTo);
            datasetStatFrontEndHelper(datasetStatFrontEnd,datasetStatList,dataset_id);
            return datasetStatFrontEnd;
        } else {
            List<DatasetStat> datasetStatList = datasetStatRepository.findAllByDatasetidAndTimestampLessThanEqual(dataset_id,dataTo);
            datasetStatFrontEndHelper(datasetStatFrontEnd,datasetStatList,dataset_id);
            return datasetStatFrontEnd;
        }
    }



}
