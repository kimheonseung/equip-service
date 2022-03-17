package com.devh.equip.service;

import com.devh.equip.entity.EquipGroup;
import com.devh.equip.repository.EquipGroupRepository;
import com.devh.equip.vo.EquipGroupVO;
import com.devh.module.api.vo.TreeVO;
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
public class EquipGroupServiceImpl implements EquipGroupService {
    private final EquipGroupRepository equipGroupRepository;

    @Override
    public EquipGroupVO findById(Long id) throws ServiceException {
        try {
            Optional<EquipGroup> optionalEquipGroup = equipGroupRepository.findById(id);
            return entityToVO(optionalEquipGroup.orElseThrow());
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<TreeVO<EquipGroupVO>> findTree() throws ServiceException {
        try {
            List<TreeVO<EquipGroupVO>> result = new ArrayList<>();

            List<EquipGroup> equipGroupList = equipGroupRepository.findAll();
            List<EquipGroupVO> equipGroupVOList = new ArrayList<>();
            equipGroupList.forEach(e -> equipGroupVOList.add(entityToVO(e)));

            for(EquipGroupVO v : equipGroupVOList) {
                v.setText();
                if(v.isRoot()) {
                    result.add(v);
                    continue;
                }

                EquipGroupVO parent = searchParent(equipGroupVOList, v);
                parent.addChild(v);
            }

            return result;
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public EquipGroupVO findByName(String name) throws ServiceException {
        try {
            Optional<EquipGroup> optionalEquipGroup = equipGroupRepository.findByName(name);
            return entityToVO(optionalEquipGroup.orElseThrow());
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Boolean save(EquipGroupVO equipGroupVO) throws ServiceException {
        try {
            EquipGroup savedEquipGroup = equipGroupRepository.save(voToEntity(equipGroupVO));
            return savedEquipGroup.getName().equals(equipGroupVO.getName());
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean update(EquipGroupVO equipGroupVO) throws ServiceException {
        try {
            final Long id = equipGroupVO.getId();
            Optional<EquipGroup> optionalEquipGroup = equipGroupRepository.findById(id);
            EquipGroup equipGroup = optionalEquipGroup.orElseThrow();

            equipGroup.setName(equipGroupVO.getName());
            equipGroup.setDescription(equipGroupVO.getDescription());
            equipGroup.setEquipGroup(EquipGroup.builder().id(equipGroupVO.getParentId()).build());
            equipGroup.setDisplayOrder(equipGroupVO.getDisplayOrder());

            EquipGroup savedEquipGroup = equipGroupRepository.save(voToEntity(equipGroupVO));
            return savedEquipGroup.getName().equals(equipGroupVO.getName());
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean deleteById(Long id) throws ServiceException {
        try {
            equipGroupRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean deleteAllById(Iterable<? extends Long> ids) throws ServiceException {
        try {
            equipGroupRepository.deleteAllById(ids);
            return true;
        } catch (Exception e) {
            log.error(ExceptionUtils.stackTraceToString(e));
            throw new ServiceException(e.getMessage());
        }
    }

    private EquipGroupVO searchParent(List<EquipGroupVO> equipGroupVOList, EquipGroupVO v) throws Exception {
        final int size = equipGroupVOList.size();
        int tryCount = 0;
        while (tryCount < size) {
            EquipGroupVO pick = equipGroupVOList.get(tryCount++);
            if(v.getParentId().equals(pick.getId()))
                return pick;
        }

        throw new Exception("Cannot find parent node. " + v.toString());
    }
}
