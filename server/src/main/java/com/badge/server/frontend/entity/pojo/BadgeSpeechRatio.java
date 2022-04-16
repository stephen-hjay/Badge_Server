package com.badge.server.frontend.entity.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadgeSpeechRatio {

    String badge_id;

    String dataset_id;

    double percentage;

    long dataFrom;

    long dataTo;

}
