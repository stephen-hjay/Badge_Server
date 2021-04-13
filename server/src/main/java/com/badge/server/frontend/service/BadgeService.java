package com.badge.server.frontend.service;

import com.badge.server.frontend.entity.Badge;
import com.badge.server.frontend.entity.Movement;
import com.badge.server.frontend.entity.MovementState;
import com.badge.server.frontend.entity.Voice;

import java.util.List;

public interface BadgeService {

    public List<Badge> getAll(String dataset_id);
    public List<Movement> getMovement(String badge_id);
    public List<MovementState> getMovementState(String badge_id);
    public List<Voice> getVoice(String badge_id);
}
