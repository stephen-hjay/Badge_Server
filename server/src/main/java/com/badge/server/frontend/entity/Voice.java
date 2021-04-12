package com.badge.server.frontend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voice {

    /*
    * {data : 'badge_id'},
                            {data : 'time_stamp',
                            render: function ( data, type, row ) {
                              return new Date(data).toLocaleString();
                            }},
                            {data : 'raw_m'},
                            {data : 'raw_f'},*/
    private int id;
    private Date date;
    private float raw_m;
    private float raw_f;
}
