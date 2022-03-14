package com.devh.equip.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipVO {
    private Long id;
    private String ip;
    private String name;
    private String equipTypeCode;
    private Boolean enable;
    private Long parentId;
    private Long equipGroupId;
    private String description;
}
