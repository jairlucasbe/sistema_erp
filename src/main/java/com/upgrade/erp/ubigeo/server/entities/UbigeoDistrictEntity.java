package com.upgrade.erp.ubigeo.server.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Table(name = "ubigeo_district", schema = "legal")
@Entity
public class UbigeoDistrictEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID uuid;

    @Column(nullable = false, unique = true, length = 2)
    private String code;

    @Column(nullable = false, unique = true, length = 6)
    private String ubigeo;

    @Column(nullable = false, length =  100)
    private String name;

    @Builder.Default
    @Column(nullable = false)
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "province_uuid", nullable = false)
    private UbigeoProvinceEntity province;
}
