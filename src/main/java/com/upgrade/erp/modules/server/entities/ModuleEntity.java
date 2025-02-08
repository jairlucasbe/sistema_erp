package com.upgrade.erp.modules.server.entities;

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
@Table(name = "modules", schema = "auth")
@Entity
public class ModuleEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID uuid;

    @Column(unique = true, nullable = false)
    private Long number;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(name = "active", nullable = false)
    private Boolean active;

}
