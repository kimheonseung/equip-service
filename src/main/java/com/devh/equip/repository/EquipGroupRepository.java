package com.devh.equip.repository;

import com.devh.equip.entity.EquipGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipGroupRepository extends JpaRepository<EquipGroup, Long> {
    Optional<EquipGroup> findByName(String name);

}
