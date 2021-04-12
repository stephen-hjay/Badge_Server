package com.badge.server.frontend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movement {
    /*
    * {data : 'badge_id'},
                            {data : 'time_stamp',
                            render: function ( data, type, row ) {
                              return new Date(data).toLocaleString();
                            }},
                            {data : 'raw_x'},
                            {data : 'raw_y'},
                            {data : 'raw_z'}
    * */
    private int id;
    private String badge_id;
    private Date time_stap;
    private float raw_x;
    private float raw_y;
    private float raw_z;
}
