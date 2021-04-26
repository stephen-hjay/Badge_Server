package com.badge.server.frontend.service;

import com.badge.server.android.Entity.Pojo.Badge;
import com.badge.server.android.Entity.Pojo.Movement;
import com.badge.server.android.Entity.Pojo.Voice;
import com.badge.server.android.Entity.analysis.ActiveRecord;
import com.badge.server.android.Entity.analysis.MovementState;
import com.badge.server.frontend.entity.pojo.DatasetStat;
import com.badge.server.frontend.entity.pojo.DatasetStatFrontEnd;
import com.badge.server.frontend.entity.pojo.NearMacsFrontEnd;
import com.badge.server.frontend.entity.pojo.NearPhoneFrontEnd;

import javax.websocket.server.PathParam;
import java.util.List;

public interface BadgeService {
    List<Badge> getAll(String dataset_id);

    List<Movement> getMovement(String badge_id);

    List<Movement> getMovement(String badge_id, Long dataFrom, Long dataTo);

    List<MovementState> getMovementState(String badge_id);

    List<MovementState> getMovementState(String badge_id, Long dataFrom, Long dataTo);

    List<Voice> getVoice(String badge_id);

    List<Voice> getVoice(String badge_id, Long dataFrom, Long dataTo);

    NearMacsFrontEnd getNearMacs(String badge_id);

//    List<NearPhoneFrontEnd> getNearPhones(String badge_id);

    List<NearPhoneFrontEnd> getNearPhones(String badge_id, String dataset_id);

    DatasetStatFrontEnd getActiveHistory(String dataset_id, Long dataFrom, Long dataTo);

    DatasetStatFrontEnd getActiveHistory(String dataset_id);

}
