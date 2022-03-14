package com.devh.equip.controller;

import com.devh.common.api.constant.ApiStatus;
import com.devh.common.api.response.ApiResponse;
import com.devh.equip.service.EquipTypeService;
import com.devh.equip.vo.EquipTypeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("equip-type")
@Slf4j
public class EquipTypeController {

    private final EquipTypeService equipTypeService;

    @GetMapping("list")
    public ApiResponse<EquipTypeVO> getList() {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipTypeService.findAll());
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("code/{code}")
    public ApiResponse<EquipTypeVO> getByCode(@PathVariable("code") String code) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipTypeService.findByCode(code));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("name/{name}")
    public ApiResponse<EquipTypeVO> getByName(@PathVariable("name") String name) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipTypeService.findByName(name));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("register")
    public ApiResponse<Boolean> postRegister(@RequestBody EquipTypeVO equipTypeVO) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipTypeService.save(equipTypeVO));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("update")
    public ApiResponse<Boolean> postUpdate(@RequestBody EquipTypeVO equipTypeVO) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipTypeService.update(equipTypeVO));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("delete/id")
    public ApiResponse<Boolean> postDeleteById(@RequestBody EquipTypeVO equipTypeVO) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipTypeService.deleteById(equipTypeVO.getId()));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    @PostMapping("delete/code")
    public ApiResponse<Boolean> postDeleteByCode(@RequestBody EquipTypeVO equipTypeVO) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipTypeService.deleteByCode(equipTypeVO.getCode()));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    @PostMapping("delete/name")
    public ApiResponse<Boolean> postDeleteByName(@RequestBody EquipTypeVO equipTypeVO) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipTypeService.deleteByName(equipTypeVO.getName()));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
