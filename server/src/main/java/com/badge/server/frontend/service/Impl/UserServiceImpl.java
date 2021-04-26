package com.badge.server.frontend.service.Impl;

import com.badge.server.frontend.DAO.AdminRepository;
import com.badge.server.frontend.entity.pojo.Admin;
import com.badge.server.frontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AdminRepository adminRepository;


    @Override
    public String getPassword(String email) {
//        Admin admin = adminRepository.findAdminByUsername(username);
        Admin admin = adminRepository.findAdminByEmail(email);
        if (admin!=null){
            return admin.getPassword();
        }else{
            return "";
        }
    }

    @Override
    public boolean register(Admin admin) {
        assert  admin!= null;
        return adminRepository.save(admin)!=null;
    }
}