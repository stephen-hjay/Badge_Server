package com.badge.server.frontend.service.Impl;

import com.badge.server.frontend.entity.Badge;
import com.badge.server.frontend.entity.Movement;
import com.badge.server.frontend.entity.MovementState;
import com.badge.server.frontend.entity.Voice;
import com.badge.server.frontend.service.BadgeService;

import java.util.List;

public class BadgeServiceImpl implements BadgeService {
    @Override
    public List<Badge> getAll(String dataset_id) {
        return null;
    }
    public List<Movement> getMovement(String badge_id) {
        return null;
    }

    @Override
    public List<MovementState> getMovementState(String badge_id) {
        return null;
    }

    @Override
    public List<Voice> getVoice(String badge_id) {
        return null;
    }
}
