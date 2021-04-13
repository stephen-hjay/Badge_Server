package com.badge.server.frontend.controller;


import com.badge.server.frontend.entity.Badge;
import com.badge.server.frontend.entity.Movement;
import com.badge.server.frontend.entity.MovementState;
import com.badge.server.frontend.entity.Voice;
import com.badge.server.frontend.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin
@RequestMapping("/badge")
public class BadgeController {
    @Autowired
    private BadgeService badgeService;

    @GetMapping("/badges")
    public List<Badge> getAll(@PathVariable("dataset_id") String dataset_id) {
        return  badgeService.getAll(dataset_id);
    }
    @GetMapping("/movement")
    public List<Movement> getMovments(@PathVariable("badge_id") String badge_id) {
        return badgeService.getMovement(badge_id);
    }
    @GetMapping("/movementstate")
    public List<MovementState> getMovmentState(@PathVariable("badge_id")String badge_id) {
        return  badgeService.getMovementState(badge_id);
    }

    @GetMapping("/voicesx")
    public List<Voice> getVoices(@PathVariable(name = "badge_id") String badge_id) {
        return  badgeService.getVoice(badge_id);
    }
}
