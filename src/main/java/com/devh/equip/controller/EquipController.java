package com.devh.equip.controller;

import com.devh.common.api.constant.ApiStatus;
import com.devh.common.api.response.ApiResponse;
import com.devh.equip.service.EquipService;
import com.devh.equip.vo.EquipVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("equip")
@Slf4j
public class EquipController {

    private final EquipService equipService;

    @GetMapping("list/type/{typeCode}")
    public ApiResponse<EquipVO> getListByEquipTypeCode(@PathVariable("typeCode") String equipTypeCode) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipService.findAllByEquipTypeCode(equipTypeCode));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("list/group/{groupId}")
    public ApiResponse<EquipVO> getListEquipGroupId(@PathVariable("groupId") Long groupId) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipService.findAllByEquipGroupId(groupId));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
