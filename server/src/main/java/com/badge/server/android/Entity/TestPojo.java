package com.badge.server.android.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestPojo {
    long id;
    LinkedList<Long> random;
}
