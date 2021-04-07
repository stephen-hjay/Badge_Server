package com.badge.server.android.Entity.JSONParser;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetaData extends DataCache {

    private String badge_id;

    protected String macAddr;

    protected String userName;

    protected String password;

    protected String userId;

    protected String dataset_id;

    protected String type;
}
