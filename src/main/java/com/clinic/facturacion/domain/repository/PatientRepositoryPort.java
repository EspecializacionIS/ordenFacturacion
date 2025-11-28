package com.clinic.facturacion.domain.repository;

import java.util.Optional;

import com.clinic.facturacion.domain.model.InsurancePolicy;

public interface PatientRepositoryPort {
	
	Optional<InsurancePolicy> findPolicyByPatientId(String patientId);
    // adicional: track copay accumulated for year
    double getAccumulatedCopayThisYear(String patientId, int year);
    void addCopay(String patientId, int year, double amount);

}
