package com.badge.server.frontend.entity.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeechRatioBar {

    String datasetId;

    ArrayList<Double> percentageList;

    ArrayList<String> badgeIdList;




    long med;
}
