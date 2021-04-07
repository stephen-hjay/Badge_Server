package com.badge.server.android.Entity.rawdata;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data
@Getter
@Setter
@Entity
@Table(name="badge")
public class Badge {
    @Id
    @Column(name = "id")
    private int badge_id;
    @Column(name = "mac_address")
    protected String macAddr;
    @Column(name = "userName")
    protected String userName;
    @Column(name = "password")
    protected String password;
    @Column(name = "userId")
    protected String userId;
    @Column(name="datasetId")
    protected String dataset_id;
    @Transient
    protected String type;


}
