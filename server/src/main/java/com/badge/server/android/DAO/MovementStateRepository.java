package com.badge.server.android.DAO;


import com.badge.server.android.Entity.analysis.MovementState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface MovementStateRepository extends JpaRepository<MovementState, Integer> {
    List<MovementState> findAllByBadgeid(String badge_id);

    List<MovementState> findAllByBadgeidAndTimestampGreaterThanEqual(String badge_id, Long dataFrom);

    List<MovementState> findAllByBadgeidAndTimestampLessThanEqual(String badge_id, Long dataTo);

    List<MovementState> findAllByBadgeidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(String badge_id, Long dataFrom, Long dataTo);

    @Query(nativeQuery = true, value = "select (1-sum(sitstate)/count(sitstate)) AS sitpercent, sum(movestate-3)/count(movestate) AS movepercent from movementstate where timestamp>=:dataFrom and timestamp<=:dataTo and badgeid=:badge_id")
    Map<String,Object> findBadgeSitPercentAndMovementPercent(String badge_id, Long dataFrom, Long dataTo);
}
