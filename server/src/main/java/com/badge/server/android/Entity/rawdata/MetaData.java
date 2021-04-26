package com.badge.server.android.Entity.rawdata;


import lombok.*;

import java.util.LinkedList;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetaData extends DataCache{

    private String badge_id;

    protected String macAddr;

    protected String userName;

    protected String password;

    protected String userId;

    protected String dataset_id;

    protected String type;

    protected LinkedList<Long> time_stamp;// yyyy-MM-dd-HH-mm-ss-mss
}
