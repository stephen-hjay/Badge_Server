package com.badge.server.android.Entity.analysis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activerecord")
public class ActiveRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "badgeid")
    private String badgeid;

    @Column(name="timestamp")
    private long timestamp;



    public ActiveRecord(String badgeid, long timestamp) {
        this.badgeid = badgeid;
        this.timestamp = timestamp;
    }
}
