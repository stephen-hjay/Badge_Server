package com.badge.server.frontend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementState {
    private int id;
    private String badge_id;
    private Date timestamp;
    private float row_x;
    private float row_y;
}
