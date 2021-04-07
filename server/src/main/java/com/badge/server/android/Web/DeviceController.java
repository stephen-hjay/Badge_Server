package com.badge.server.android.Web;


import com.alibaba.druid.support.json.JSONUtils;
import com.badge.server.GlobalParameters;
import com.badge.server.android.Entity.JSONParser.MetaData;
import com.badge.server.android.Entity.Utils.AndroidRequest;
import com.badge.server.android.Entity.Utils.AndroidResponse;
import com.badge.server.android.Service.AndroidDeviceService;
import com.badge.server.android.Utils.AES;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/dev")
public class DeviceController {
    @Autowired
    AndroidDeviceService androidDeviceService;
    @Autowired
    AndroidResponse androidResponse;

    ObjectMapper mapper = new ObjectMapper();

    @PostMapping(value="/login")
    public String login(HttpSession session, @RequestBody AndroidRequest androidRequest){

        String dataJSon = androidRequest.getData();
        dataJSon = AES.Decryption.decrypt(dataJSon, GlobalParameters.Encryption.secretKey,
                GlobalParameters.Encryption.algorithm);
        MetaData metaDataLogin = JSON.parseObject(dataJSon,MetaData.class);
//        // primitive user login authentication
//        if(session.getAttribute("user")==null){
//            if (androidDeviceService.login()){
//                androidResponse.setSuccess("true");
//            }else{
//
//            }
//
//        }else{
//
//        }
        System.out.println(metaDataLogin);

        return androidResponse.toString();
    }



}
