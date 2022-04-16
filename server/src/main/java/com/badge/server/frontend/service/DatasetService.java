package com.badge.server.frontend.service;



import com.badge.server.frontend.entity.pojo.Dataset;

import java.util.List;

public interface DatasetService {
    public List<Dataset> getAll();
}