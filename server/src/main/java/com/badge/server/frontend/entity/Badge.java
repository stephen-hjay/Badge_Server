package com.badge.server.frontend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Badge {
    /*{data : 'badge_id',
                      render: function ( data, type, row, meta ) {
                        return `<a href= '/dev/dataset/badge?dataset_id=${dataset_id}&badge_id=${data}'>${data}</a>`;
                      }},
                      {data : 'dataset_id'},
                      {data : 'mac_address'},
                      {data : 'time_stamp',
                      render: function ( data, type, row ) {
                        return new Date(data).toLocaleString();
                      }},
                      {data : 'user_id'},
                      {data : 'user_name'}*/
    private int id;
    private String badge_id;
    private String dataset_id;
    private String mac_address;
    private Date time_stamp;
    private String user_id;
    private String user_name;
}
