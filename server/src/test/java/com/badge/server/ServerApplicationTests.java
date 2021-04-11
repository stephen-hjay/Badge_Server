package com.badge.server;

import com.badge.server.android.DAO.MovementRepository;
import com.badge.server.android.Entity.Pojo.Movement;
import com.badge.server.android.Utils.AES;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ServerApplicationTests {
    @Autowired
    MovementRepository movementRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testJPARepositoryMovement(){
        LinkedList<Movement> movementLinkedList = new LinkedList<>();
        Movement movement = new Movement();
        movement.setDatasetid("testdataset");
        movement.setBadgeid("testbadge");
        movement.setId(null);
        movement.setX(1L);
        movement.setY(1L);
        movement.setZ(1L);
        movement.setTimestamp(1L);
        movementLinkedList.offer(movement);
       movementRepository.saveAll(movementLinkedList);
    }

    @Test
    void testDecryption(){
        String json = "{\"data\":\"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\",\"type\":\"ACCELEROMETERS\"}";
        String decryptedJson = AES.Decryption.decrypt(json,GlobalParameters.Encryption.secretKey,GlobalParameters.Encryption.secretKey);
        System.out.println(decryptedJson);


    }


}
