package com.badge.server.frontend.entity.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "datasetstat")
public class DatasetStat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "datasetid")
    String datasetid;

    @Column(name="num")
    Integer num;

    @Column(name="timestamp")
    Long timestamp;


}
