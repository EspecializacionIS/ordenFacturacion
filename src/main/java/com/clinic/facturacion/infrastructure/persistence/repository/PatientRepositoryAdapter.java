package com.clinic.facturacion.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.clinic.facturacion.domain.model.InsurancePolicy;
import com.clinic.facturacion.domain.repository.PatientRepositoryPort;
import com.clinic.facturacion.infrastructure.persistence.entity.CopayEntity;

@Component
public class PatientRepositoryAdapter implements PatientRepositoryPort {
	
	private final SpringCopayRepository copayRepo;

    public PatientRepositoryAdapter(SpringCopayRepository copayRepo) {
        this.copayRepo = copayRepo;
    }

    @Override
    public Optional<InsurancePolicy> findPolicyByPatientId(String patientId) {
        // Implementación mínima: retorna vacío. Puedes integrar con tabla de pólizas o servicio externo.
        return Optional.empty();
    }

    @Override
    public double getAccumulatedCopayThisYear(String patientId, int year) {
        return copayRepo.findByPatientIdAndYear(patientId, year)
                .map(CopayEntity::getAccumulated)
                .orElse(0.0);
    }

    @Override
    public void addCopay(String patientId, int year, double amount) {
        CopayEntity entity = copayRepo.findByPatientIdAndYear(patientId, year)
                .orElseGet(() -> {
                    CopayEntity ce = new CopayEntity();
                    ce.setPatientId(patientId);
                    ce.setYear(year);
                    ce.setAccumulated(0.0);
                    return ce;
                });
        entity.setAccumulated(entity.getAccumulated() + amount);
        copayRepo.save(entity);
    }
}
