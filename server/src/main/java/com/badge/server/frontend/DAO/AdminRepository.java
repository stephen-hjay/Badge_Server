package com.badge.server.frontend.DAO;

import com.badge.server.frontend.entity.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
//    Admin findAdminByUsername(String username);
    Admin findAdminByEmail(String email);

    Admin findByEmailAndAndPassword(String email, String passwd);
}
