package com.badge.server.frontend.Controller;

import com.badge.server.frontend.Utils.Bean.FrontendReponse;
import com.badge.server.frontend.entity.pojo.Admin;
import com.badge.server.frontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getPassword(@PathParam("email")String email) {
        return userService.getPassword(email);
    }



    @PostMapping
    public FrontendReponse register(Admin admin) {
        FrontendReponse frontendReponse = new FrontendReponse("false");
        if (userService.register(admin)){
            frontendReponse.setSuccess("true");
        }
        return frontendReponse;
    }
}