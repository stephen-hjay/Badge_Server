package com.badge.server.android.Entity.rawdata;

import lombok.*;

import java.util.LinkedList;


@Getter
public class DataCache{
    public String type;
    public String badge_id;
    public String dataset_id;
    public LinkedList<Long> time_stamp;// yyyy-MM-dd-HH-mm-ss-mss
    // public LinkedList<Integer> data;

}
