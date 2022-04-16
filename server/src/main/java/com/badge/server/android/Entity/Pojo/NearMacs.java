package com.badge.server.android.Entity.Pojo;


import lombok.*;
import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
@Table(name = "nearmacs")
public class NearMacs  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "timestamp")
    protected long timestamp;

    @Column(name = "badgemacid")
    protected String badgemacid;

    @Column(name="badgeid")
    protected String badgeid;

    @Column(name = "nearmacaddr")
    protected String nearmacaddr;

}
