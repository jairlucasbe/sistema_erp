package com.upgrade.erp.ubigeo.server.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.upgrade.erp.ubigeo.server.entities.UbigeoDistrictEntity;

@Repository
public interface UbigeoDistrictRepository extends JpaRepository<UbigeoDistrictEntity, UUID> { }
