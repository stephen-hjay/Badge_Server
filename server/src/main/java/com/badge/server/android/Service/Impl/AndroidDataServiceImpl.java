package com.badge.server.android.Service.Impl;

import com.badge.server.GlobalParameters;
import com.badge.server.android.DAO.*;
import com.badge.server.android.Entity.Pojo.*;
import com.badge.server.android.Entity.analysis.ActiveRecord;
import com.badge.server.android.Entity.analysis.MovementState;
import com.badge.server.android.Entity.rawdata.*;
import com.badge.server.android.Entity.Utils.JSON2RawData;
import com.badge.server.android.Service.AndroidDeviceService;
import com.badge.server.android.Utils.MovementProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AndroidDataServiceImpl implements AndroidDeviceService {
    @Autowired
    static Object loginLock = new Object();

    @Autowired
    MovementStateRepository movementStateRepository;

    @Autowired
    BadgeRepository badgeRepository;

    @Autowired
    MovementRepository movementRepository;

    static Object movementLock = new Object();

    @Autowired
    VoiceRepository voiceRepository;

    static Object voiceLock = new Object();


    @Autowired
    QRCodeRepository qrCodeRepository;

    static Object qrCodeLock = new Object();


    @Autowired
    NearMacsRepository nearMacsRepository;

    static Object nearMacsLock = new Object();


//    @Autowired
//    ActiveRecordRepository activeRecordRepository;

    @Override
    public boolean login(MetaData metaData, ServletContext servletContext) {
        assert metaData != null;
        Badge badge = JSON2RawData.meta2Badge(metaData);
            ConcurrentHashMap<String,Long> onlineBadges = (ConcurrentHashMap<String, Long>) servletContext.getAttribute("badge");
            if (!onlineBadges.containsKey(metaData.getBadge_id())){
                if (badgeRepository.findByIdAndPassword(badge.getId(),badge.getPassword())!=null){
                    onlineBadges.put(metaData.getBadge_id(),System.currentTimeMillis());
                    System.out.println(badge+"login success");
                    return true;
                }
                System.out.println(badge+"login failed");
                return false;
            }else{
                return true;
            }
        }


    @Override
    public void saveMovement(Accelerator accelerator, HttpSession httpSession) {
        assert accelerator != null;
        long time1 = System.currentTimeMillis();
        ArrayList<Movement> movementArrayList = JSON2RawData.acc2Movement(accelerator);
        persistenceActiveRecord(accelerator,httpSession);
        synchronized (movementLock) {
            if (movementArrayList.size() > 0) {
//              System.out.println(movementSerialNum.getAndIncrement());
                movementRepository.saveAll(movementArrayList);
                movementStateRepository.saveAll(saveLastSec(httpSession,accelerator));
//                System.out.println("Accelerator Time Consumption:" + (System.currentTimeMillis() - time1));
            }
        }
    }

    private void persistenceActiveRecord(Accelerator accelerator, HttpSession httpSession){
        // persistence the record
        long currentTime = System.currentTimeMillis();
        ConcurrentHashMap<String,Long> onlineBadges = (ConcurrentHashMap<String, Long>) httpSession.getServletContext().getAttribute("badge");
        onlineBadges.put(accelerator.getBadge_id(),currentTime);
    }


    @Override
    public void saveVoice(Microphone microphone) {
        assert microphone!=null;
        long time1 = System.currentTimeMillis();
        LinkedList<Voice> voiceLinkedList = JSON2RawData.microphone2Voice(microphone);
        synchronized (voiceLock){
            if (voiceLinkedList.size() > 0) {
//                System.out.println(voiceSerialNum++);
                voiceRepository.saveAll(voiceLinkedList);
//                System.out.println("Voice Time Consumption:" + (System.currentTimeMillis() - time1));
            }
        }
    }

    @Override
    public void saveNearMacs(MacAddress macAddress) {
        assert macAddress!=null;
        long time1 = System.currentTimeMillis();
        LinkedList<NearMacs> nearMacsLinkedList = JSON2RawData.macaddr2nearmacs(macAddress);
        synchronized (nearMacsLock){
            if (nearMacsLinkedList.size() > 0) {
//                System.out.println(nearMacsSerialNum++);
                nearMacsRepository.saveAll(nearMacsLinkedList);
//                System.out.println("Mac Time Consumption:" + (System.currentTimeMillis() - time1));
            }
        }
    }

    @Override
    public void saveQRCode(QRCode_raw qrCode_raw){
        assert qrCode_raw!=null;
        long time1 = System.currentTimeMillis();
        QRCode qrCode = JSON2RawData.qrCodeTransform(qrCode_raw);
        synchronized (qrCodeLock){
            if (qrCode!=null){
//                System.out.println(qrCodeSerialNum++);
                qrCodeRepository.save(qrCode);
//                System.out.println("QRCode Time Consumption:" + (System.currentTimeMillis() - time1));
            }
        }
    }

    private ArrayList<MovementState> saveLastSec(HttpSession httpSession, Accelerator accelerator){
        int[] movementstate = MovementProcess.getMovementState(httpSession,accelerator);
        ArrayList<MovementState> movementStateArrayList = new ArrayList<>();
        for (int i=0;i<accelerator.getTime_stamp().size();i++){
            MovementState movementState = new MovementState();
            movementState.setBadgeid(accelerator.getBadge_id());
            movementState.setTimestamp(accelerator.getTime_stamp().get(i));
            movementState.setBadgeid(accelerator.getBadge_id());
            movementState.setSitstate(movementstate[0]);
            movementState.setMovestate(movementstate[1]);
            movementStateArrayList.add(movementState);
        }
        return movementStateArrayList;
    }

}
