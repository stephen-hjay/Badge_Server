package com.badge.server.android.DAO;
//
//
import com.badge.server.android.Entity.Pojo.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

//@Repository
public interface BadgeRepository extends JpaRepository<Badge,String> {
     Badge findByIdAndPassword(String badge_id, String password);

     Badge findBadgeById(String badgeid);

     List<Badge> findAllByDatasetid(String datasetid);

     @Query(nativeQuery = true, value = "select datasetid from badge where id=:badgeid")
     String findDatasetByBadgeid(String badgeid);

     @Query(nativeQuery = true, value = "select id from badge where datasetid=:datasetid")
     List<Map<String,Object>> findBadgesByDatasetId(String datasetid);

     @Transactional
     @Modifying()
     @Query(value = " UPDATE badge SET datasetid =:datasetid  WHERE id =:badgeid", nativeQuery = true)
     int assignDataset(String badgeid, String datasetid);




}
