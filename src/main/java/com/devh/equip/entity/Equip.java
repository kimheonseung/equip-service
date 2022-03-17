package com.devh.equip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "EQUIP")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Equip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15, nullable = false)
    private String ip;
    @Column(length = 30, nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(referencedColumnName = "CODE", name = "EQUIP_TYPE_CODE", foreignKey = @ForeignKey(name = "FK_EQUIP_EQUIP_TYPE"))
    private EquipType equipType;
    @Column(length = 100, nullable = false)
    private String os;
    @ColumnDefault("TRUE")
    private Boolean enable;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID", foreignKey = @ForeignKey(name = "FK_EQUIP_EQUIP"))
    @ColumnDefault("NULL")
    private Equip equip;
    @ManyToOne
    @JoinColumn(name = "EQUIP_GROUP_ID", foreignKey = @ForeignKey(name = "FK_EQUIP_EQUIP_GROUP"))
    @ColumnDefault("NULL")
    private EquipGroup equipGroup;
    @Column(length = 30)
    @ColumnDefault("NULL")
    private String description;
}
