package com.badge.server.frontend.entity.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadgeMovementRatio {
    String badge_id;

    String dataset_id;

    BigDecimal sitPercent;

    BigDecimal movementPercent;
}
