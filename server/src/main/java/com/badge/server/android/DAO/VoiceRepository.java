package com.badge.server.android.DAO;


import com.badge.server.android.Entity.Pojo.Voice;
import com.badge.server.android.Entity.analysis.MovementState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VoiceRepository extends JpaRepository<Voice,Long> {
    List<Voice> findAllByBadgeid(String badge_id);

    List<Voice> findAllByBadgeidAndTimestampGreaterThanEqual(String badge_id, Long dataFrom);

    List<Voice> findAllByBadgeidAndTimestampLessThanEqual(String badge_id, Long dataTo);

    List<Voice> findAllByBadgeidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(String badge_id, Long dataFrom, Long dataTo);

}
