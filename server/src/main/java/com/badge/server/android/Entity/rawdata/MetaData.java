package com.badge.server.android.Entity.rawdata;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MetaData {

    protected String type;
    protected String badge_id;
    protected String dataset_id;
}
