package com.badge.server.android.DAO;


import com.badge.server.android.Entity.Pojo.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement,Long> {
    List<Movement> findAllByBadgeid(String badge_id);

    List<Movement> findAllByBadgeidAndTimestampGreaterThanEqual(String badgeid, Long dataFrom);

    List<Movement> findAllByBadgeidAndTimestampLessThanEqual(String badgeid,Long dataTo);

    List<Movement> findAllByBadgeidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(String badgeid, Long dataFrom, Long dataTo);
}
