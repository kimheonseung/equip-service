package com.devh.equip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <pre>
 * Description :
 *     EQUIP_GROUP 테이블 엔티티
 * ===============================================
 * Member fields :
 *
 * ===============================================
 *
 * Author : HeonSeung Kim
 * Date   : 2022. 3. 12.
 * </pre>
 */
@Entity
@Table(name = "EQUIP_GROUP")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String name;
    @Column(length = 400)
    @ColumnDefault("NULL")
    private String description;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID", foreignKey = @ForeignKey(name = "FK_EQUIP_GROUP_EQUIP_GROUP"))
    @ColumnDefault("NULL")
    private EquipGroup equipGroup;
    @ColumnDefault("0")
    private Integer displayOrder;
}
