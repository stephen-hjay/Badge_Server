package com.badge.server.android.Entity.rawdata;


import lombok.*;

import java.util.LinkedList;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accelerator {

    private String badge_id;

    protected String dataset_id;

    protected String type;

    protected LinkedList<Long> time_stamp;// yyyy-MM-dd-HH-mm-ss-mss

    protected LinkedList<Float> x;

    protected LinkedList<Float> y;

    protected LinkedList<Float> z;

}
