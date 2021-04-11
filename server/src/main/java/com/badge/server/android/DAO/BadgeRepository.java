package com.badge.server.android.DAO;
//
//
import com.badge.server.android.Entity.Pojo.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface BadgeRepository extends JpaRepository<Badge,String> {
     Badge findByIdAndPassword(String badge_id, String password);
}
