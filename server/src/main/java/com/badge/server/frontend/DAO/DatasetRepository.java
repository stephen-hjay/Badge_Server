package com.badge.server.frontend.DAO;

import com.badge.server.frontend.entity.pojo.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatasetRepository extends JpaRepository<Dataset,Integer> {
}
