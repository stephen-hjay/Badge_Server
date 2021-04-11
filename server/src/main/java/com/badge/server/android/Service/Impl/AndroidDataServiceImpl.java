package com.badge.server.android.Service.Impl;

import com.badge.server.android.DAO.*;
import com.badge.server.android.Entity.Pojo.*;
import com.badge.server.android.Entity.rawdata.*;
import com.badge.server.android.Entity.Utils.JSON2RawData;
import com.badge.server.android.Service.AndroidDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AndroidDataServiceImpl implements AndroidDeviceService {
    @Autowired
    BadgeRepository badgeRepository;

    @Autowired
    MovementRepository movementRepository;

    static AtomicInteger movementSerialNum = new AtomicInteger(0);
    static Object movementLock = new Object();

    @Autowired
    VoiceRepository voiceRepository;

    static Object voiceLock = new Object();

    static int voiceSerialNum;


    @Autowired
    QRCodeRepository qrCodeRepository;

    static Object qrCodeLock = new Object();

    static int qrCodeSerialNum;


    @Autowired
    NearMacsRepository nearMacsRepository;

    static Object nearMacsLock = new Object();

    static int nearMacsSerialNum;

    @Override
    public boolean login(MetaData metaData, HttpSession session) {
        assert metaData != null;
        Badge badge = JSON2RawData.meta2Badge(metaData);

        if (session.getAttribute("badge")==null){
            if (badgeRepository.findByIdAndPassword(badge.getId(),badge.getPassword())!=null){
                session.setAttribute("badge",badge.getId());
                System.out.println(badge+"login success");
                return true;
            }
            System.out.println(badge+"login failed");
            return false;
        }else{
            return  validationSession(badge,session);
        }
    }

    @Override
    public void saveMovement(Accelerator accelerator) {
        assert accelerator != null;
        synchronized (movementLock) {
           long time1 = System.currentTimeMillis();
           LinkedList<Movement> movementLinkedList = JSON2RawData.acc2Movement(accelerator);
           System.out.println(movementSerialNum.getAndIncrement());
            if (movementLinkedList.size() > 0) {
                movementRepository.saveAll(movementLinkedList);
                System.out.println("Accelerator Time Consumption:" + (System.currentTimeMillis() - time1));
            }
        }
    }


    @Override
    public void saveVoice(Microphone microphone) {
        assert microphone!=null;
        synchronized (voiceLock){
            long time1 = System.currentTimeMillis();
            LinkedList<Voice> voiceLinkedList = JSON2RawData.microphone2Voice(microphone);
            System.out.println(voiceSerialNum++);
            if (voiceLinkedList.size() > 0) {
                voiceRepository.saveAll(voiceLinkedList);
                System.out.println("Voice Time Consumption:" + (System.currentTimeMillis() - time1));
            }
        }
    }

    @Override
    public void saveNearMacs(MacAddress macAddress) {
        assert macAddress!=null;
        synchronized (nearMacsLock){
            long time1 = System.currentTimeMillis();
            LinkedList<NearMacs> nearMacsLinkedList = JSON2RawData.macaddr2nearmacs(macAddress);
            System.out.println(nearMacsSerialNum++);
            if (nearMacsLinkedList.size() > 0) {
                nearMacsRepository.saveAll(nearMacsLinkedList);
                System.out.println("Mac Time Consumption:" + (System.currentTimeMillis() - time1));
            }
        }
    }

    @Override
    public void saveQRCode(QRCode_raw qrCode_raw){
        assert qrCode_raw!=null;
        synchronized (qrCodeLock){
            long time1 = System.currentTimeMillis();
            QRCode qrCode = JSON2RawData.qrCodeTransform(qrCode_raw);
            System.out.println(qrCodeSerialNum++);
            qrCodeRepository.save(qrCode);
            System.out.println("QRCode Time Consumption:" + (System.currentTimeMillis() - time1));
        }
    }



    public boolean validationSession(Badge badge, HttpSession session){
        return session.getAttribute("badge").equals(badge.getId());
    }



}
