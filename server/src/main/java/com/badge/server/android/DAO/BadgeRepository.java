package com.badge.server.android.DAO;
//
//
import com.badge.server.android.Entity.Pojo.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface BadgeRepository extends JpaRepository<Badge,String> {
     Badge findByIdAndPassword(String badge_id, String password);

     List<Badge> findAllByDatasetid(String datasetid);

     @Query(nativeQuery = true, value = "select datasetid from badge where id=:badgeid")
     String findDatasetByBadgeid(String badgeid);

}
