package com.badge.server.frontend.entity.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class NearPhoneFrontEnd {

    String badgeid;

    String datasetid;

    long timestamp;

    List<String> nearAddress;

    public NearPhoneFrontEnd(List<String> nearAddress) {
        this.nearAddress = nearAddress;
    }
}
