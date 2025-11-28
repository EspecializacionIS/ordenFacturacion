package com.clinic.facturacion.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.facturacion.infrastructure.persistence.entity.CopayEntity;

public interface SpringCopayRepository extends JpaRepository<CopayEntity, Long> {
	
	Optional<CopayEntity> findByPatientIdAndYear(String patientId, Integer year);

}
