package com.upgrade.erp.server.entities.inventory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Table(name = "vechicles", schema = "authentication")
@Entity
public class VehicleEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID uuid;

    @Column(unique = true, nullable = false)
    private String plate;

    @Column(unique = true, nullable = false)
    private Long brand;

    @Column()
    private String certificate;

    @Column()
    private String description;

    @Column(name = "active", nullable = false)
    private Boolean active;
}
