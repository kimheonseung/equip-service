package com.devh.equip.repository;

import com.devh.equip.entity.Equip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipRepository extends JpaRepository<Equip, Long> {
    List<Equip> findAllByEquipTypeCode(String equipTypeCode);
    List<Equip> findAllByEquipGroupId(Long equipGroupId);
}
