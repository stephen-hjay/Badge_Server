//package com.badge.server.android.Entity.Pojo;
//
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "loginrecord")
//public class LoginRecord {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    protected Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "badgeid", referencedColumnName = "id")
//    protected String badgeid;
//
//    @Column(name = "timestamp")
//    protected long timestamp;
//
//
//    public LoginRecord(String badge_id, Long timestamp) {
//        this.id =null;
//        this.badgeid = badge_id;
//        this.timestamp = timestamp;
//    }
//}
