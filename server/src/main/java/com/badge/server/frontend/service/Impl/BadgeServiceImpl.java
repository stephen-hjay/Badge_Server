package com.badge.server.frontend.service.Impl;

import com.badge.server.android.DAO.*;
import com.badge.server.android.Entity.Pojo.Badge;
import com.badge.server.android.Entity.Pojo.Movement;
import com.badge.server.android.Entity.Pojo.Voice;
import com.badge.server.android.Entity.analysis.ActiveRecord;
import com.badge.server.android.Entity.analysis.MovementState;
import com.badge.server.frontend.DAO.DatasetStatRepository;
import com.badge.server.frontend.entity.pojo.DatasetStat;
import com.badge.server.frontend.entity.pojo.DatasetStatFrontEnd;
import com.badge.server.frontend.entity.pojo.NearMacsFrontEnd;
import com.badge.server.frontend.entity.pojo.NearPhoneFrontEnd;
import com.badge.server.frontend.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

//    @Autowired
//    ActiveRecordRepository activeRecordRepository;

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
    public DatasetStatFrontEnd getActiveHistory(String dataset_id, Long dataFrom, Long dataTo) {
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

    @Override
    public DatasetStatFrontEnd getActiveHistory(String dataset_id) {
        DatasetStatFrontEnd datasetStatFrontEnd = new DatasetStatFrontEnd();
        List<DatasetStat> datasetStatList = datasetStatRepository.findAllByDatasetid(dataset_id);
        datasetStatFrontEndHelper(datasetStatFrontEnd,datasetStatList,dataset_id);
        return datasetStatFrontEnd;
    }


    private void datasetStatFrontEndHelper(DatasetStatFrontEnd datasetStatFrontEnd, List<DatasetStat> datasetStatList, String datasetid){
        datasetStatFrontEnd.setDatasetid(datasetid);
        ArrayList<Integer> stats = new ArrayList<>();
        ArrayList<Long> timestamps = new ArrayList<>();
        System.out.println("======================="+datasetStatList);
        for(DatasetStat datasetStat : datasetStatList){
            stats.add(datasetStat.getNum());
            timestamps.add(datasetStat.getTimestamp());
        }
        datasetStatFrontEnd.setNums(stats);
        datasetStatFrontEnd.setTimestamps(timestamps);
    }

}
