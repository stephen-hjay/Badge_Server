package com.badge.server.frontend.service;

import com.badge.server.frontend.entity.Admin;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public String getPassword(String username);
    public Admin register(Admin admin);
}
