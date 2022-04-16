package com.badge.server.frontend.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class NearMacsFrontEnd {

    List<List<String>> listMacAddress;
    List<Long> listTimeStamp;

    public NearMacsFrontEnd() {
        this.listMacAddress = new ArrayList<>();
        this.listTimeStamp = new ArrayList<>();
    }
}
