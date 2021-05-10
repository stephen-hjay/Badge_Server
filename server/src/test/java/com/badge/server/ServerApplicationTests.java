package com.badge.server;

import com.alibaba.fastjson.JSON;
import com.badge.server.android.DAO.BadgeRepository;
import com.badge.server.android.DAO.MovementRepository;
import com.badge.server.android.DAO.VoiceRepository;
import com.badge.server.android.Entity.Pojo.Movement;
import com.badge.server.android.Entity.TestPojo;
import com.badge.server.android.Utils.AES;
import com.badge.server.frontend.DAO.DatasetRepository;
import com.badge.server.frontend.DAO.DatasetStatRepository;
import com.badge.server.frontend.entity.pojo.Dataset;
import com.badge.server.frontend.entity.pojo.DatasetStat;
import com.badge.server.frontend.entity.pojo.SpeechRatioBar;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ServerApplicationTests {
//    @Autowired
//    MovementRepository movementRepository;
//
//    @Autowired
//    DatasetRepository datasetRepository;
//
//    @Autowired
//    BadgeRepository badgeRepository;
//
//    @Autowired
//    DatasetStatRepository datasetStatRepository;
//
//    @Autowired
//    VoiceRepository voiceRepository;
//
//    @Test
//    public void testSpeechRatio(){
////        List<Map<String,Double>> queryResult = voiceRepository.findByCalculatingPower("Nokia3",1619553001759L,1619553615896L);
////
////        for (Map<String,Double> powerPair: queryResult){
//////            System.out.println(powerPair);
////            for (String power: powerPair.keySet()){
////                System.out.println(power+":"+powerPair.get(power));
//////                System.out.println(powerPair.get(power));
////            }
////        }
//
//
//    }
//
//
//    @Test
//    public void testSpeechRatio2(){
//        List<Map<String,Object>> queryResult = voiceRepository.findFrequency("Nokia3",1619553107758L,1619553616316L);
//        for (Map<String,Object> powerPair: queryResult){
////            System.out.println(powerPair);
//            for (String power: powerPair.keySet()){
//                System.out.println(power+":"+powerPair.get(power));
////                System.out.println(powerPair.get(power));
//            }
//        }
//    }
//
//    @Test
//    public void testMovementRatio2(){
//
//    }
//
//
////    @Test
////    void testDatasetQuery(){
////        System.out.println(badgeRepository.findDatasetByBadgeid("device-0513-3"));
////    }
//    @Test
//    public void testDatasetStat(){
////        for (String datasetid : datasetStatMap.keySet()){
//            DatasetStat datasetStat = new DatasetStat();
//            datasetStat.setDatasetid("Nokia3");
//            datasetStat.setNum(1);
//            datasetStat.setTimestamp(System.currentTimeMillis());
//            datasetStatRepository.save(datasetStat);
////        }
//    }
//
//
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void testJPARepositoryMovement(){
//        LinkedList<Movement> movementLinkedList = new LinkedList<>();
//        Movement movement = new Movement();
//        movement.setDatasetid("testdataset");
//        movement.setBadgeid("testbadge");
//        movement.setId(null);
//        movement.setX(1L);
//        movement.setY(1L);
//        movement.setZ(1L);
//        movement.setTimestamp(1L);
////        movementLinkedList.offer();
//       movementRepository.saveAll(movementLinkedList);
//    }
//
//    @Test
//    void testDecryption(){
//        String json = "{\"data\":\"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\",\"type\":\"ACCELEROMETERS\"}";
//        String decryptedJson = AES.Decryption.decrypt(json,GlobalParameters.Encryption.secretKey,GlobalParameters.Encryption.secretKey);
//        System.out.println(decryptedJson);
//
//    }
//
//    @Test
//    void testNetwork(){
//        System.out.println("++++++++++Test+++++++++++");
//        for(int i=0;i<7;i++){
//            Thread t = new Thread(new MyThread());
//            t.start(); // 启动新线程
//        }
//        while(true){
//
//        }
//    }
//
//
//    public static void postDataWithParam(String jsonStr, long threadnum) {
//
//        OkHttpClient client = new OkHttpClient();
//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//        long currentVersion = System.currentTimeMillis();
//        RequestBody body = RequestBody.create(jsonStr, JSON);
//        Request request = new Request.Builder().url("http://192.168.1.9:8080/dev/apitest").post(body).build();
//        client.newCall(request).enqueue((new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                System.out.println("============fail:"+threadnum);
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                System.out.println("success");
//
//            }
//        }));
//    }
//
//    class MyThread implements Runnable{
//        @Override
//        public void run() {
//            System.out.println("new Thread");
//            while(true){
//                TestPojo testpojo = new TestPojo();
//                testpojo.setRandom(new LinkedList<>());
//                testpojo.setId(Thread.currentThread().getId());
//                int cnt = 0;
//                while(cnt++<600){
//                    try {
//                        Thread.sleep(10);
//                        testpojo.getRandom().add(System.currentTimeMillis());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                String jsonStr = JSON.toJSONString(testpojo);
//                postDataWithParam(jsonStr, Thread.currentThread().getId());
//            }
//        }
//    }
//
//    @Test
//    void test1(){
//        long timestamp = System.currentTimeMillis();
//        Date date = new Date(timestamp);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(JSON.toJSON(date));
//        System.out.println(simpleDateFormat.format(date));
//
//    }
//
//
//    @Test
//    void testDatasetRepo(){
//        List<Dataset> datasetList = datasetRepository.findAll();
//        for (Dataset dataset : datasetList){
//            System.out.println(dataset);
//        }
//    }
//




}
