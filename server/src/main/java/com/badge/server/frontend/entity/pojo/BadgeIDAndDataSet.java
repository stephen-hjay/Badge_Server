package com.badge.server.frontend.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadgeIDAndDataSet {
    String datasetid;

    String badgeid;
}
