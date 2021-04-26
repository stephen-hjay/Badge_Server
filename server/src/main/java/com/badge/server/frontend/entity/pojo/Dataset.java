package com.badge.server.frontend.entity.pojo;
import com.badge.server.android.Entity.Pojo.Badge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dataset")
public class Dataset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "datasetid")
    private String datasetid;

    @Column(name="admin")
    private String admin;

    @Column(name = "datasetname")
    private String datasetname;

    @Column(name="description")
    private String description;

    @Column(name = "numberofbadges")
    private int numberofbadges;

    @Column(name="timestamp")
    private Long timestamp;
}