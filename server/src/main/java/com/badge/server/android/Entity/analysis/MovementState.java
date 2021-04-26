package com.badge.server.android.Entity.analysis;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "movementstate")
public class MovementState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "timestamp")
    protected long timestamp;

    @Column(name="badgeid")
    protected String badgeid;

    @Column(name = "sitstate")
    protected int sitstate;

    @Column(name="movestate")
    protected int movestate;
}
