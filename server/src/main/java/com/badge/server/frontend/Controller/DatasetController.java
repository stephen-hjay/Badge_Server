package com.badge.server.frontend.Controller;

import com.badge.server.frontend.entity.pojo.Dataset;
import com.badge.server.frontend.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/dataset")
@CrossOrigin
public class DatasetController {
    @Autowired
    private DatasetService datasetService;
    @GetMapping
    public List<Dataset> getAll() {
        return datasetService.getAll();
    }



}