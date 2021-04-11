package com.badge.server.android.DAO;

import com.badge.server.android.Entity.Pojo.NearMacs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NearMacsRepository extends JpaRepository<NearMacs,Long> {
}
