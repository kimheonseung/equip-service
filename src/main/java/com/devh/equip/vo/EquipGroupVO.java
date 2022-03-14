package com.devh.equip.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipGroupVO {
    private Long id;
    private String name;
    private String description;
    private Long parentId;
    private Integer displayOrder;
}
