package com.tw.apistackbase.service;

import com.tw.apistackbase.module.CrimeConstitution;
import com.tw.apistackbase.repository.CrimeConstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrimeConstitutionService {

    @Autowired
    private CrimeConstitutionRepository crimeConstitutionRepository;

    public CrimeConstitution createCrimeConstitution(CrimeConstitution crimeConstitution) {
        return crimeConstitutionRepository.save(crimeConstitution);
    }

    public List<CrimeConstitution> findAllCrimeConstitution() {
        return crimeConstitutionRepository.findAll();
    }

    public Optional<CrimeConstitution> findById(int crimeConstitutionId) {
        return crimeConstitutionRepository.findById(crimeConstitutionId);
    }
}
