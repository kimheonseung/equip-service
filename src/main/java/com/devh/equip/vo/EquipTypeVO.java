package com.devh.equip.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipTypeVO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String icon;
}
