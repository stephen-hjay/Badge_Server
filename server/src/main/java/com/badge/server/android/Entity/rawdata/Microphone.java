package com.badge.server.android.Entity.rawdata;

import lombok.*;

import java.util.LinkedList;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Microphone extends DataCache{
    private String badge_id;

    protected String dataset_id;

    protected String type;

    protected LinkedList<Long> time_stamp;// yyyy-MM-dd-HH-mm-ss-mss

    protected LinkedList<Double> decibel;

    protected LinkedList<Double> frequency;
}
