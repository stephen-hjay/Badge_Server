package com.badge.server.android.Entity.Pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data
@Getter
@Setter
@Entity
@Table(name="badge")
public class Badge{
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "macaddr")
    protected String macaddr;
    @Column(name = "username")
    protected String username;
    @Column(name = "password")
    protected String password;
    @Column(name = "userid")
    protected String userid;
    @Column(name="datasetid")
    protected String datasetid;

    @Column(name="timestamp")
    protected long timestamp;

    @Transient
    protected String type;

}
