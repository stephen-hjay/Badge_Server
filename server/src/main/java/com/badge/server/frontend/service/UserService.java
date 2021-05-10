package com.badge.server.frontend.service;

import com.badge.server.android.Entity.Pojo.Badge;
import com.badge.server.frontend.entity.pojo.Admin;
import com.badge.server.frontend.entity.pojo.BadgeAssignment;
import com.badge.server.frontend.entity.pojo.BadgeIDAndDataSet;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    String getPassword(String username);

    boolean register(Admin admin);

    boolean login(String email, String password);

    boolean registerBadge(Badge badge);

    List<BadgeIDAndDataSet> getBadges();

    boolean assignBadges(BadgeAssignment badgeAssignment);

}