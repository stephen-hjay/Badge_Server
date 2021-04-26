package com.badge.server.frontend.service;

import com.badge.server.frontend.entity.pojo.Admin;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public String getPassword(String username);
    public boolean register(Admin admin);
}