package com.devh.equip.service;

import com.devh.common.api.vo.TreeVO;
import com.devh.common.exception.ServiceException;
import com.devh.equip.entity.EquipGroup;
import com.devh.equip.vo.EquipGroupVO;

import java.util.List;

public interface EquipGroupService {
    EquipGroupVO findById(Long id) throws ServiceException;
    List<TreeVO<EquipGroupVO>> findTree() throws ServiceException;
    EquipGroupVO findByName(String name) throws ServiceException;
    Boolean save(EquipGroupVO equipGroupVO) throws ServiceException;
    Boolean update(EquipGroupVO equipGroupVO) throws ServiceException;
    Boolean deleteById(Long id) throws ServiceException;
    Boolean deleteAllById(Iterable<? extends Long> ids) throws ServiceException;

    default EquipGroup voToEntity(EquipGroupVO v) {
        if(v == null)
            return null;
        else
            return EquipGroup.builder()
                   .id(v.getId())
                   .name(v.getName())
                   .description(v.getDescription())
                   .equipGroup(v.getParentId() == null ? null : EquipGroup.builder().id(v.getParentId()).build())
                   .displayOrder(v.getDisplayOrder())
            .build();
    }

    default EquipGroupVO entityToVO(EquipGroup e) {
        if(e == null)
            return null;
        else
            return EquipGroupVO.builder()
                    .id(e.getId())
                    .name(e.getName())
                    .description(e.getDescription())
                    .parentId(e.getEquipGroup() == null ? null : e.getEquipGroup().getId())
                    .displayOrder(e.getDisplayOrder())
            .build();
    }
}
