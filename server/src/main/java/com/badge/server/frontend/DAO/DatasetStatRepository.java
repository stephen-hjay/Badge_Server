package com.badge.server.frontend.DAO;


import com.badge.server.frontend.entity.pojo.DatasetStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DatasetStatRepository extends JpaRepository<DatasetStat,String> {
    List<DatasetStat> findAllByDatasetid(String datasetid);

    List<DatasetStat> findAllByDatasetidAndTimestampGreaterThanEqual(String datasetid, Long dataFrom);

    List<DatasetStat> findAllByDatasetidAndTimestampLessThanEqual(String datasetid,Long dataTo);

    List<DatasetStat> findAllByDatasetidAndTimestampGreaterThanEqualAndTimestampLessThanEqual(String datasetid,Long dataFrom, Long dataTo);

    @Query(nativeQuery = true, value = "select MAX(num) from datasetstat where datasetid=:datasetid and timestamp >=:dataFrom and timestamp <=:dataTo")
    Integer findMaxByDatasetidAndTimestampAfterAndTimestampBefore(String datasetid, Long dataFrom, Long dataTo);

}
