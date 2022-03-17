package com.devh.equip.service;

import com.devh.equip.entity.Equip;
import com.devh.equip.entity.EquipGroup;
import com.devh.equip.entity.EquipType;
import com.devh.equip.vo.EquipVO;
import com.devh.module.exception.ServiceException;

import java.util.List;

public interface EquipService {

    default Equip voToEntity(EquipVO v) {
        if(v == null)
            return null;
        else
            return Equip.builder()
                    .id(v.getId())
                    .ip(v.getIp())
                    .name(v.getName())
                    .equipType(v.getEquipTypeCode() == null ? null : EquipType.builder().code(v.getEquipTypeCode()).build())
                    .os(v.getOs())
                    .enable(v.getEnable())
                    .equip(v.getParentId() == null ? null : Equip.builder().id(v.getParentId()).build())
                    .equipGroup(v.getEquipGroupId() == null ? null : EquipGroup.builder().id(v.getEquipGroupId()).build())
                    .description(v.getDescription())
            .build();
    }

    default EquipVO entityToVO(Equip e) {
        if(e == null)
            return null;
        else
            return EquipVO.builder()
                    .id(e.getId())
                    .ip(e.getIp())
                    .name(e.getName())
                    .equipTypeCode(e.getEquipType() == null ? null : e.getEquipType().getCode())
                    .os(e.getOs())
                    .enable(e.getEnable())
                    .parentId(e.getEquip() == null ? null : e.getEquip().getId())
                    .equipGroupId(e.getEquipGroup() == null ? null : e.getEquipGroup().getId())
                    .description(e.getDescription())
            .build();
    }

    public List<EquipVO> findAllByEquipTypeCode(String equipTypeCode) throws ServiceException;
    public List<EquipVO> findAllByEquipGroupId(Long equipGroupId) throws ServiceException;
}
