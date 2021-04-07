package com.badge.server.frontend.controller;


import com.badge.server.frontend.entity.Admin;
import com.badge.server.frontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@CrossOrigin
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getPassword(@PathParam("name")String name) {
        return userService.getPassword(name);
    }

    @PostMapping
    public Admin register(Admin admin) {
        return userService.register(admin);
    }
}
