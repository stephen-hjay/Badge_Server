package com.badge.server.frontend.service.Impl;

import com.badge.server.android.DAO.BadgeRepository;
import com.badge.server.android.Entity.Pojo.Badge;
import com.badge.server.frontend.DAO.AdminRepository;
import com.badge.server.frontend.entity.pojo.Admin;
import com.badge.server.frontend.entity.pojo.BadgeAssignment;
import com.badge.server.frontend.entity.pojo.BadgeIDAndDataSet;
import com.badge.server.frontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    BadgeRepository badgeRepository;

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

    @Override
    public boolean login(String email, String password) {
        if (adminRepository.findByEmailAndAndPassword(email,password)!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean registerBadge(Badge badge) {
        Badge badgeFound = badgeRepository.findBadgeById(badge.getId());
        if (badgeFound==null){
            badgeRepository.save(badge);
            return true;
        }
        return false;
    }

    @Override
    public List<BadgeIDAndDataSet> getBadges() {
        List<Badge> allBadges = badgeRepository.findAll();
        List<BadgeIDAndDataSet> badges = new ArrayList<>();
        for (Badge badge: allBadges){
            BadgeIDAndDataSet badgeIDAndDataSet = new BadgeIDAndDataSet();
            badgeIDAndDataSet.setBadgeid(badge.getId());
            badgeIDAndDataSet.setDatasetid(badge.getDatasetid());
            badges.add(badgeIDAndDataSet);
        }
        return badges;
    }

    @Override
    public boolean assignBadges(BadgeAssignment badgeAssignment) {
        List<String> badgeList = badgeAssignment.getSelected_badges();
        for (String badge: badgeList){
            int result = badgeRepository.assignDataset(badge,badgeAssignment.getDataset_id());
            System.out.println(result);
            if (result!=1){
                return false;
            }
        }
        return true;
    }


}