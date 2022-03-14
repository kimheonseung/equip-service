package com.devh.equip.repository;

import com.devh.equip.entity.EquipType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipTypeRepository extends JpaRepository<EquipType, Long> {
    Optional<EquipType> findByCode(String code);
    Optional<EquipType> findByName(String name);
    void deleteByCode(String code);
    void deleteByName(String name);
}
