package com.badge.server.frontend.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BadgeAssignment {

    String dataset_id;

    List<String> selected_badges;

}
