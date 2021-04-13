package com.badge.server.frontend.service.Impl;

import com.badge.server.frontend.entity.Dataset;
import com.badge.server.frontend.service.DatasetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasetServiceImpl implements DatasetService {
    @Override
    public List<Dataset> getAll(String admin) {
        return null;
    }
}
