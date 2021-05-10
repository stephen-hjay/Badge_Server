package com.badge.server.frontend.DAO;

import com.badge.server.frontend.entity.pojo.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatasetRepository extends JpaRepository<Dataset,Integer> {


}
