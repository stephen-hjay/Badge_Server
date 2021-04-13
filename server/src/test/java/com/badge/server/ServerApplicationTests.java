package com.badge.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {
    @Test
    public void maint() {
        System.out.println(System.currentTimeMillis());
    }

}
