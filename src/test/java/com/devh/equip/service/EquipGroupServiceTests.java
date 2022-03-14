package com.devh.equip.service;

import com.devh.common.exception.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EquipGroupServiceTests {
    @Autowired
    EquipGroupService equipGroupService;

    @Test
    public void test_tree() {
        try {
            System.out.println(equipGroupService.findTree());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
