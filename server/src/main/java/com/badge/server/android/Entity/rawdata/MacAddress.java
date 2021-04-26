package com.badge.server.android.Entity.rawdata;

import lombok.*;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MacAddress extends DataCache {
    private String badge_id;

    protected String dataset_id;

    protected String type;

    protected LinkedList<Long> time_stamp;// yyyy-MM-dd-HH-mm-ss-mss

    protected ArrayList<String> a;


}
