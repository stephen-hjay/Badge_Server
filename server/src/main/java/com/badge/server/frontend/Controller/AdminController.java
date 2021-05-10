package com.badge.server.frontend.Controller;

import com.badge.server.android.Entity.Pojo.Badge;
import com.badge.server.frontend.Utils.Bean.FrontendReponse;
import com.badge.server.frontend.entity.pojo.Admin;
import com.badge.server.frontend.entity.pojo.BadgeAssignment;
import com.badge.server.frontend.entity.pojo.BadgeIDAndDataSet;
import com.badge.server.frontend.entity.pojo.Result;
import com.badge.server.frontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public Result login(@RequestParam("email")String email, @RequestParam("passwd")String passwd) {
        if (userService.login(email,passwd)) {
            return new Result(0, "Success", email);
        }
        return new Result(1, "Fail", email);
    }


    @PostMapping
    public FrontendReponse register(Admin admin) {
        FrontendReponse frontendReponse = new FrontendReponse("false");
        if (userService.register(admin)){
            frontendReponse.setSuccess("true");
        }
        return frontendReponse;
    }
    
    @PostMapping("/badgeregister")
    public String  registerBadge(Badge badge){
        if(userService.registerBadge(badge)){
            return "register successfully";
        }else{
            return "register fail";
        }
    }

    @GetMapping("/getbadges")
    public List<BadgeIDAndDataSet> getBadges(){
        return userService.getBadges();
    }

//    @GetMapping("/assign")
//    public String assignBadges(@RequestBody BadgeAssignment badgeAssignment){
//        System.out.println("new");
//        if (!userService.assignBadges(badgeAssignment)){
//            return "fail";
//        }
//        return "success";
//    }

    @PostMapping("/assign")
    public String assignBadges(@RequestBody BadgeAssignment badgeAssignment){
        System.out.println("new");
        System.out.println(badgeAssignment);
        if (!userService.assignBadges(badgeAssignment)){
            return "fail";
        }
        return "success";
    }

    
}