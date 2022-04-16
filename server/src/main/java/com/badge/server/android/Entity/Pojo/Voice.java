package com.badge.server.android.Entity.Pojo;

import lombok.*;
import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voice")
public class Voice  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="frequency")
    protected double frequency;

    @Column(name="decibel")
    protected double decibel;

    @Column(name = "badgeid")
    protected String badgeid;

    @Column(name="datasetid")
    protected String datasetid;

    @Column(name="timestamp")
    private long timestamp;

}
