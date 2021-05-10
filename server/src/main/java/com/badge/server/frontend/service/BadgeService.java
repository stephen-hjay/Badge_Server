package com.badge.server.frontend.service;

import com.badge.server.android.Entity.Pojo.Badge;
import com.badge.server.android.Entity.Pojo.Movement;
import com.badge.server.android.Entity.Pojo.Voice;
import com.badge.server.android.Entity.analysis.ActiveRecord;
import com.badge.server.android.Entity.analysis.MovementState;
import com.badge.server.frontend.entity.pojo.*;

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

    List<DatasetStatBar> getActiveHistory(String dataset_id, Long dataFrom, Long dataTo, int minute);

    DatasetStatFrontEnd getActiveHistory(String dataset_id, int minute);

    List<SpeechRatioBar> getSpeechRatio(String dataset_id, Long dataFrom, Long dataTo, int minute);

    List<BadgeSpeechRatio> getSpeechRatio(String dataset_id, Long dataFrom, Long dataTo);

    List<BadgeMovementRatio> getMovementRatio(String dataset_id, Long dataFrom, Long dataTo);

}
