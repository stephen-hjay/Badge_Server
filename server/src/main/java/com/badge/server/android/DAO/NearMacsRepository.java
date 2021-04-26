package com.badge.server.android.DAO;

import com.badge.server.android.Entity.Pojo.NearMacs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface NearMacsRepository extends JpaRepository<NearMacs,Long> {
    List<NearMacs> findAllByBadgeid(String badge_id);

    @Query(nativeQuery = true, value = "select distinct timestamp from nearmacs where badgeid=:badgeid order by timestamp")
    List<Long> findTimeStamp(@Param("badgeid") String badgeid);

    @Query(nativeQuery = true, value = "select nearmacaddr from nearmacs where badgeid=:badgeid and timestamp = :timestamp ")
    List<String> findMacAddress(@Param("badgeid") String badgeid, @Param("timestamp") Long timestamp);



}
