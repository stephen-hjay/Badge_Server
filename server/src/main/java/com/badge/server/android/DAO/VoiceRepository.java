package com.badge.server.android.DAO;


import com.badge.server.android.Entity.Pojo.Voice;
import com.badge.server.android.Entity.analysis.MovementState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


public interface VoiceRepository extends JpaRepository<Voice,Long> {
    List<Voice> findAllByBadgeid(String badge_id);

    List<Voice> findAllByBadgeidAndTimestampGreaterThanEqual(String badge_id, Long dataFrom);

    List<Voice> findAllByBadgeidAndTimestampLessThanEqual(String badge_id, Long dataTo);

    List<Voice> findAllByBadgeidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(String badge_id, Long dataFrom, Long dataTo);


    @Query(nativeQuery = true, value = "select SUM(frequency * decibel) AS power, badgeid from voice where datasetid=:datasetid and timestamp >=:dataFrom and timestamp <=:dataTo group by badgeid order by badgeid")
    List<Map<String,Object>> findByCalculatingPower(String datasetid, Long dataFrom, Long dataTo);
    // <column name, value>
    // badgeid:device-0513-4
    // power:4468.303808060918
    // badgeid:device-0513-3
    // power:1872.1214224510081

    @Query(nativeQuery = true, value = "select SUM(frequency)/COUNT(frequency) AS percentage, badgeid from voice where datasetid=:datasetid and timestamp >=:dataFrom and timestamp <=:dataTo group by badgeid")
    List<Map<String,Object>> findFrequency(String datasetid, Long dataFrom, Long dataTo);


}
