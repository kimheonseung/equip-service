package com.devh.equip.service;

import com.devh.common.exception.ServiceException;
import com.devh.equip.entity.EquipType;
import com.devh.equip.vo.EquipTypeVO;

import java.util.List;

public interface EquipTypeService {
    EquipTypeVO findByCode(String code) throws ServiceException;
    EquipTypeVO findByName(String name) throws ServiceException;
    List<EquipTypeVO> findAll() throws ServiceException;
    Boolean save(EquipTypeVO equipTypeVO) throws ServiceException;
    Boolean update(EquipTypeVO equipTypeVO) throws ServiceException;
    Boolean deleteById(Long id) throws ServiceException;
    Boolean deleteByCode(String code) throws ServiceException;
    Boolean deleteByName(String name) throws ServiceException;

    default EquipTypeVO entityToVO(EquipType e) {
        if(e == null)
            return null;
        else
            return EquipTypeVO.builder()
                    .id(e.getId())
                    .code(e.getCode())
                    .name(e.getName())
                    .description(e.getDescription())
                    .icon(e.getIcon())
            .build();
    }

    default EquipType voToEntity(EquipTypeVO v) {
        if(v == null)
            return null;
        else
            return EquipType.builder()
                    .id(v.getId())
                    .code(v.getCode())
                    .name(v.getName())
                    .description(v.getDescription())
                    .icon(v.getIcon())
            .build();
    }
}
