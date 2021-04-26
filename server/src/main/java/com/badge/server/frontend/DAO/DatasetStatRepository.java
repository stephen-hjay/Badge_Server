package com.badge.server.frontend.DAO;


import com.badge.server.frontend.entity.pojo.DatasetStat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatasetStatRepository extends JpaRepository<DatasetStat,String> {
    List<DatasetStat> findAllByDatasetid(String datasetid);

    List<DatasetStat> findAllByDatasetidAndTimestampGreaterThanEqual(String datasetid, Long dataFrom);

    List<DatasetStat> findAllByDatasetidAndTimestampLessThanEqual(String datasetid,Long dataTo);

    List<DatasetStat> findAllByDatasetidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(String datasetid,Long dataFrom, Long dataTo);

}
