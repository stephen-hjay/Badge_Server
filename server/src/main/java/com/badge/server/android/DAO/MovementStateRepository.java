package com.badge.server.android.DAO;


import com.badge.server.android.Entity.analysis.MovementState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementStateRepository extends JpaRepository<MovementState, Integer> {
    List<MovementState> findAllByBadgeid(String badge_id);

    List<MovementState> findAllByBadgeidAndTimestampGreaterThanEqual(String badge_id, Long dataFrom);

    List<MovementState> findAllByBadgeidAndTimestampLessThanEqual(String badge_id, Long dataTo);

    List<MovementState> findAllByBadgeidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(String badge_id, Long dataFrom, Long dataTo);
}
