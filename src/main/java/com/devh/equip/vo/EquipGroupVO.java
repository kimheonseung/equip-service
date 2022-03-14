package com.devh.equip.vo;

import com.devh.common.api.vo.TreeVO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class EquipGroupVO extends TreeVO<EquipGroupVO> {
    private Long id;
    private String name;
    private String description;
    private Long parentId;
    private Integer displayOrder;

    @Override
    public boolean isRoot() {
        return parentId == null;
    }
    @Override
    public void setText() {
        super.text = this.name;
    }
}
