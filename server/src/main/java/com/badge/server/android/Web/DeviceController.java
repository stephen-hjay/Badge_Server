package com.badge.server.android.Web;

import com.badge.server.GlobalParameters;
import com.badge.server.android.Entity.rawdata.*;
import com.badge.server.android.Entity.Utils.*;
import com.badge.server.android.Service.AndroidDeviceService;
import com.badge.server.android.Utils.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/dev")
public class DeviceController {
    @Autowired
    AndroidDeviceService androidDeviceService;
    @Autowired
    AndroidResponse androidResponse;

    @PostMapping(value="/login")
    public String login(HttpSession session, @RequestBody AndroidRequest androidRequest){
//        System.out.println("new Phone");
        String dataJson = AES.Decryption.decrypt(androidRequest.getData(),
                GlobalParameters.Encryption.secretKey,GlobalParameters.Encryption.algorithm);
        MetaData metaData = JSON.parseObject(dataJson,MetaData.class);
        if (androidDeviceService.login(metaData,session.getServletContext())){
            androidResponse.setSuccess("true");
        }else{
            androidResponse.setSuccess("false");
        }
        return JSON.toJSONString(androidResponse);
    }


    @PostMapping(value = "/api")
    public String api(HttpSession session, @RequestBody AndroidRequest androidRequest){
        long time1 = System.currentTimeMillis();
        String dataJson = AES.Decryption.decrypt(androidRequest.getData(),
                GlobalParameters.Encryption.secretKey,GlobalParameters.Encryption.algorithm);
        String type = androidRequest.getType();
        switch (type){
            case "ACCELEROMETERS":
                Accelerator accelerator = JSON.parseObject(dataJson,Accelerator.class);
                if (validation(session,accelerator)){
                    androidDeviceService.saveMovement(accelerator,session);
                    androidResponse.setSuccess("true");
                }else{
                    androidResponse.setSuccess("false");
                }
                break;
            case "MICROPHONE":
                Microphone microphone = JSON.parseObject(dataJson,Microphone.class);
                if (validation(session,microphone)){
                    androidDeviceService.saveVoice(microphone);
                    androidResponse.setSuccess("true");
                }else{
                    androidResponse.setSuccess("false");
                }
                break;
            case "QRCODE":
                QRCode_raw qrCode_raw = JSON.parseObject(dataJson,QRCode_raw.class);
                androidDeviceService.saveQRCode(qrCode_raw);
                if (validation(session,qrCode_raw)){
                    androidDeviceService.saveQRCode(qrCode_raw);
                    androidResponse.setSuccess("true");
                }else{
                    androidResponse.setSuccess("false");
                }
                break;
            case "BLUETOOTH":
                MacAddress macAddress = JSON.parseObject(dataJson,MacAddress.class);
                if (validation(session,macAddress)){
                    androidDeviceService.saveNearMacs(macAddress);
                    androidResponse.setSuccess("true");
                }else{
                    androidResponse.setSuccess("false");
                }
        }
        return JSON.toJSONString(androidResponse);
    }

    @PostMapping(value = "/apitest")
    public String movement( @RequestBody String str){
        System.out.println("received");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        androidResponse.setSuccess("true");
        return JSON.toJSONString(androidResponse);
    }

    private boolean validation(HttpSession httpSession, DataCache dataCache){
        Map<String,Long> onlineBadges = (Map<String, Long>) httpSession.getServletContext().getAttribute("badge");
        if (onlineBadges.containsKey(dataCache.getBadge_id())
                && System.currentTimeMillis() - onlineBadges.get(dataCache.getBadge_id())<= GlobalParameters.timeout){
            return true;
        }
        return false;
    }


}
