package com.devh.equip.service;

import com.devh.equip.entity.EquipType;
import com.devh.equip.repository.EquipTypeRepository;
import com.devh.equip.vo.EquipTypeVO;
import com.devh.module.exception.ServiceException;
import com.devh.module.exception.util.ExceptionUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EquipTypeServiceImpl implements EquipTypeService {

    private final EquipTypeRepository equipTypeRepository;

    @Override
    public EquipTypeVO findByCode(String code) throws ServiceException {
        try {
            Optional<EquipType> optionalEquipType = equipTypeRepository.findByCode(code);
            return entityToVO(optionalEquipType.orElseThrow());
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public EquipTypeVO findByName(String name) throws ServiceException {
        try {
            Optional<EquipType> optionalEquipType = equipTypeRepository.findByName(name);
            return entityToVO(optionalEquipType.orElseThrow());
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<EquipTypeVO> findAll() throws ServiceException {
        try {
            List<EquipType> equipTypeList = equipTypeRepository.findAll();
            List<EquipTypeVO> resultList = new ArrayList<>();
            equipTypeList.forEach(e -> resultList.add(entityToVO(e)));
            return resultList;
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Boolean save(EquipTypeVO equipTypeVO) throws ServiceException {
        try {
            EquipType equipType = voToEntity(equipTypeVO);
            EquipType savedEquipType = equipTypeRepository.save(equipType);
            return equipType.getCode().equals(savedEquipType.getCode());
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean update(EquipTypeVO equipTypeVO) throws ServiceException {
        try {
            final String equipTypeCode = equipTypeVO.getCode();
            Optional<EquipType> optionalEquipType = equipTypeRepository.findByCode(equipTypeCode);
            EquipType equipType = optionalEquipType.orElseThrow();

            equipType.setName(equipTypeVO.getName());
            equipType.setDescription(equipTypeVO.getDescription());
            equipType.setIcon(equipTypeVO.getIcon());

            EquipType savedEquipType = equipTypeRepository.save(equipType);

            return savedEquipType.getCode().equals(equipTypeCode);
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean deleteById(Long id) throws ServiceException {
        try {
            equipTypeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }
    @Transactional
    @Override
    public Boolean deleteByCode(String code) throws ServiceException {
        try {
            equipTypeRepository.deleteByCode(code);
            return true;
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }
    @Transactional
    @Override
    public Boolean deleteByName(String name) throws ServiceException {
        try {
            equipTypeRepository.deleteByName(name);
            return true;
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }
}
