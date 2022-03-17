package com.devh.equip.controller;

import com.devh.equip.service.EquipGroupService;
import com.devh.equip.vo.EquipGroupVO;
import com.devh.module.api.constant.ApiStatus;
import com.devh.module.api.response.ApiResponse;
import com.devh.module.api.vo.TreeVO;
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
@RequestMapping("equip-group")
@Slf4j
public class EquipGroupController {

    private final EquipGroupService equipGroupService;

    @GetMapping("tree")
    public ApiResponse<TreeVO<EquipGroupVO>> getTree() {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipGroupService.findTree());
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("id/{id}")
    public ApiResponse<EquipGroupVO> getById(@PathVariable("id") Long id) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipGroupService.findById(id));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("name/{name}")
    public ApiResponse<EquipGroupVO> getById(@PathVariable("name") String name) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipGroupService.findByName(name));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("register")
    public ApiResponse<Boolean> postRegister(@RequestBody EquipGroupVO equipGroupVO) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipGroupService.save(equipGroupVO));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("update")
    public ApiResponse<Boolean> postUpdate(@RequestBody EquipGroupVO equipGroupVO) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipGroupService.update(equipGroupVO));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("delete/id")
    public ApiResponse<Boolean> postDeleteById(@RequestBody EquipGroupVO equipGroupVO) {
        try {
            return ApiResponse.success(ApiStatus.Success.OK, equipGroupService.deleteById(equipGroupVO.getId()));
        } catch (Exception e) {
            return ApiResponse.serverError(ApiStatus.ServerError.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
