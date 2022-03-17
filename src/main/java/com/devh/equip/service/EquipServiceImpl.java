package com.devh.equip.service;

import com.devh.equip.entity.Equip;
import com.devh.equip.repository.EquipRepository;
import com.devh.equip.vo.EquipVO;
import com.devh.module.exception.ServiceException;
import com.devh.module.exception.util.ExceptionUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EquipServiceImpl implements EquipService {

    private final EquipRepository equipRepository;

    @Override
    public List<EquipVO> findAllByEquipTypeCode(String equipTypeCode) throws ServiceException {
        try {
            List<EquipVO> result = new ArrayList<>();
            List<Equip> equipList = equipRepository.findAllByEquipTypeCode(equipTypeCode);
            equipList.forEach(e -> result.add(entityToVO(e)));
            return result;
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<EquipVO> findAllByEquipGroupId(Long equipGroupId) throws ServiceException {
        try {
            List<EquipVO> result = new ArrayList<>();
            List<Equip> equipList = equipRepository.findAllByEquipGroupId(equipGroupId);
            equipList.forEach(e -> result.add(entityToVO(e)));
            return result;
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }
}
