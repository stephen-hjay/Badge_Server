package com.badge.server.frontend.service.Impl;


import com.badge.server.frontend.DAO.DatasetRepository;
import com.badge.server.frontend.entity.pojo.Dataset;
import com.badge.server.frontend.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasetServiceImpl implements DatasetService {

    @Autowired
    DatasetRepository datasetRepository;


    @Override
    public List<Dataset> getAll() {
        return datasetRepository.findAll();
    }
}