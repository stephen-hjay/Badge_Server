package com.badge.server.android.Entity.Pojo;


import lombok.*;
import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "badgeid")
    protected String badgeid;

    @Column(name = "x")
    protected float x;

    @Column(name = "y")
    protected float y;

    @Column(name = "z")
    protected float z;

    @Column(name = "timestamp")
    protected long timestamp;

    @Column(name="datasetid")
    protected String datasetid;


}
