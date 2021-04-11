package com.badge.server.android.DAO;


import com.badge.server.android.Entity.Pojo.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement,Long> {

}
