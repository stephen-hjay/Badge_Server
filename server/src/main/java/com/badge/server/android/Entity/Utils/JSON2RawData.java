package com.badge.server.android.Entity.Utils;

import com.badge.server.android.Entity.Pojo.*;
import com.badge.server.android.Entity.rawdata.*;

import java.util.ArrayList;
import java.util.LinkedList;
//import com.badge.server.android.Entity.Pojo.LoginRecord;

public class JSON2RawData {

    public static Badge meta2Badge(MetaData meta){
        Badge badge = new Badge();
        badge.setId(meta.getBadge_id());
        badge.setMacaddr(meta.getMacAddr());
        badge.setUsername(meta.getUserName());
        badge.setDatasetid(meta.getDataset_id());
        badge.setPassword(meta.getPassword());
        badge.setType(meta.getType());
        badge.setUserid(meta.getUserId());
        return badge;
    }

//    public static LoginRecord meta2LoginRecord(MetaData metaData){
//        return new LoginRecord(metaData.getBadge_id(),metaData.getTime_stamp().peek());
//
//    }


    public static LinkedList<Movement> acc2Movement(Accelerator accelerator){
        LinkedList<Movement> movementLinkedList = new LinkedList<>();
        if (accelerator!=null){
            LinkedList<Long> timestamp = accelerator.getTime_stamp();
//            System.out.println("timesize:"+timestamp.size());
            LinkedList<Float> x = accelerator.getX();
//            System.out.println("Xsize:"+x.size());
            LinkedList<Float> y = accelerator.getY();
//            System.out.println("ysize:"+y.size());
            LinkedList<Float> z = accelerator.getZ();
//            System.out.println("zsize:"+z.size());
            int size = Math.min(x.size(),Math.min(y.size(),Math.min(z.size(),timestamp.size())));
            for (int i=0;i< size;i++){
                Movement movement = new Movement();
                movement.setDatasetid(accelerator.getDataset_id());
                movement.setBadgeid(accelerator.getBadge_id());
                movement.setId(null);
                movement.setX(x.pollFirst());
                movement.setY(y.pollFirst());
                movement.setZ(z.pollFirst());
                movement.setTimestamp(timestamp.pollFirst());
                movementLinkedList.offer(movement);
            }
        }
       return movementLinkedList;
    }


    public static  LinkedList<Voice> microphone2Voice(Microphone microphone){
        LinkedList<Voice> voiceLinkedList = new LinkedList<>();
        LinkedList<Long> timeLinkedList = microphone.getTime_stamp();
        LinkedList<Double> decibelLinkedList = microphone.getDecibel();
        LinkedList<Double> frequencyLinkedList = microphone.getFrequency();
        for (int i=0;i<decibelLinkedList.size();i++){
            Voice voice = new Voice();
            voice.setBadgeid(microphone.getBadge_id());
            voice.setDatasetid(microphone.getDataset_id());
            voice.setDecibel(decibelLinkedList.pollFirst());
            voice.setFrequency(frequencyLinkedList.pollFirst());
            voice.setTimestamp(timeLinkedList.pollFirst());
            voiceLinkedList.add(voice);
        }
        return voiceLinkedList;
    }

    public static QRCode qrCodeTransform(QRCode_raw qrCode_raw){
        QRCode qrCode = new QRCode();
        qrCode.setBadgeid(qrCode_raw.getBadge_id());
        qrCode.setDatasetid(qrCode_raw.getDataset_id());
        qrCode.setQrcode(qrCode_raw.getResult().getFirst());
        qrCode.setTime_stamp(qrCode_raw.getTime_stamp().getFirst());
        return qrCode;
    }

    public static LinkedList<NearMacs> macaddr2nearmacs(MacAddress macAddress){
        LinkedList<NearMacs> nearMacsLinkedList = new LinkedList<>();
        LinkedList<Long> time_stamp = macAddress.getTime_stamp();
        ArrayList<String> macaddresses = macAddress.getA();
        for (int i=0;i<macaddresses.size()-1;i++){
            NearMacs nearMacs = new NearMacs();
            nearMacs.setBadgeid(macAddress.getBadge_id());
            nearMacs.setBadgemacid(macaddresses.get(macaddresses.size()-1));
            nearMacs.setTimestamp(time_stamp.pollFirst());
            nearMacs.setNearmacaddr(macaddresses.get(i));
            nearMacsLinkedList.offer(nearMacs);
        }
        return nearMacsLinkedList;
    }

}
