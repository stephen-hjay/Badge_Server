package com.badge.server.frontend.controller;

import com.badge.server.frontend.entity.Dataset;
import com.badge.server.frontend.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/dataset")
@CrossOrigin
public class DatasetController {
    @Autowired
    private DatasetService datasetService;
    @GetMapping("/getbadge")
    public List<Dataset> getAll(@PathVariable(name = "admin") String admin) {
        return datasetService.getAll(admin);
    }
}
