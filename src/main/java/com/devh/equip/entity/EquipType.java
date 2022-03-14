package com.devh.equip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Description :
 *     EQUIP_TYPE 테이블 엔티티
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
@Table(name = "EQUIP_TYPE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String code;
    @Column(length = 50, nullable = false, unique = true)
    private String name;
    @Column(length = 200)
    @ColumnDefault("NULL")
    private String description;
    @Column(length = 100)
    @ColumnDefault("NULL")
    private String icon;
}
