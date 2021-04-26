package com.badge.server.android.Entity.Pojo;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
@Table(name="qrcode")
public class QRCode  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="qrcode")
    protected String qrcode;

    @Column(name="timestamp")
    protected long time_stamp;

    @Column(name = "badgeid")
    protected String badgeid;

    @Column(name="datasetid")
    protected String datasetid;

}
