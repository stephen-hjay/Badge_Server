package com.badge.server.frontend.entity;

import com.badge.server.android.Entity.rawdata.Badge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dataset {
    private int id;
    private String dataset_id;
    private String admin;
    private String dataset_name;
    private String description;
    private int numberofBadges;
    private Date time_stamp;
    private List<Badge> badges;
}
