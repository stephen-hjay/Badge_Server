package com.badge.server.android.Web;

import com.badge.server.GlobalParameters;
import com.badge.server.android.Entity.rawdata.*;
import com.badge.server.android.Entity.Utils.*;
import com.badge.server.android.Service.AndroidDeviceService;
import com.badge.server.android.Utils.AES;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/dev")
public class DeviceController {
    @Autowired
    AndroidDeviceService androidDeviceService;
    @Autowired
    AndroidResponse androidResponse;


//
//    Object movementLock = new Object();
//
//    int cntMovement = 0;


    @PostMapping(value="/login")
    public String login(HttpSession session, @RequestBody AndroidRequest androidRequest){

        String dataJson = AES.Decryption.decrypt(androidRequest.getData(),
                GlobalParameters.Encryption.secretKey,GlobalParameters.Encryption.algorithm);
        MetaData metaData = JSON.parseObject(dataJson,MetaData.class);

        if (androidDeviceService.login(metaData,session)){
            androidResponse.setSuccess("true");
        }else{
            androidResponse.setSuccess("false");
        }
//        System.out.println(androidResponseJson);
        return JSON.toJSONString(androidResponse);
    }


    @PostMapping(value = "/api")
    public String api(HttpSession session, @RequestBody AndroidRequest androidRequest){

        String dataJson = AES.Decryption.decrypt(androidRequest.getData(),
                GlobalParameters.Encryption.secretKey,GlobalParameters.Encryption.algorithm);
        String type = androidRequest.getType();
        System.out.println(type+":"+androidRequest.version);
        switch (type){
            case "ACCELEROMETERS":
                Accelerator accelerator = JSON.parseObject(dataJson,Accelerator.class);
                androidDeviceService.saveMovement(accelerator);
                break;
            case "MICROPHONE":
                Microphone microphone = JSON.parseObject(dataJson,Microphone.class);
                androidDeviceService.saveVoice(microphone);
                break;
            case "QRCODE":
                QRCode_raw qrCode_raw = JSON.parseObject(dataJson,QRCode_raw.class);
                androidDeviceService.saveQRCode(qrCode_raw);
                break;
            case "BLUETOOTH":
                MacAddress macAddress = JSON.parseObject(dataJson,MacAddress.class);

        }

        androidResponse.setSuccess("true");
        return JSON.toJSONString(androidResponse);
    }


}
