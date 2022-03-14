package com.devh.equip.service;

import com.devh.common.exception.ServiceException;
import com.devh.equip.vo.EquipTypeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
public class EquipTypeServiceTests {
    @Autowired
    EquipTypeService equipTypeService;

    @Test
    public void test_findAll() {
        try {
            List<EquipTypeVO> equipTypeVOList = equipTypeService.findAll();
            equipTypeVOList.forEach(System.out::println);
            assertEquals(equipTypeVOList.size(), 2);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_findByCode() {
        try {
            EquipTypeVO equipTypeVO = equipTypeService.findByCode("SERVER");
            System.out.println(equipTypeVO);
            assertEquals(equipTypeVO.getCode(), "SERVER");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_findByName() {
        try {
            EquipTypeVO equipTypeVO = equipTypeService.findByName("서버");
            System.out.println(equipTypeVO);
            assertEquals(equipTypeVO.getName(), "서버");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_save() {
        try {
            assertTrue(equipTypeService.save(EquipTypeVO.builder()
                    .code("C1")
                    .name("NM")
                    .description("DC")
                    .build()));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_update() {
        try {
            assertTrue(equipTypeService.update(EquipTypeVO.builder()
                    .code("C1")
                    .name("NM")
                    .description("dd")
                    .build()));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_deleteByCode() {
        try {
            assertTrue(equipTypeService.deleteByCode("C1"));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
