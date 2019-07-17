package com.tw.apistackbase.service;

import com.tw.apistackbase.module.Case;
import com.tw.apistackbase.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseService {
    @Autowired
    private CaseRepository caseRepository;

    public Case createCase(Case caseInfo) {
        caseInfo.setOccurrenceTime(System.currentTimeMillis());
        return caseRepository.save(caseInfo);
    }

    public List<Case> findAllCasesOrderByTime() {
        Sort sort = new Sort(Sort.Direction.DESC,"occurrenceTime");
        return caseRepository.findAll(sort);
    }

    public Optional<Case> findById(int caseId) {
        return caseRepository.findById(caseId);
    }

    public List<Case> findByCaseName(String caseName) {
        return caseRepository.findByCaseName(caseName);
    }

    public void deleteById(int caseId) {
        caseRepository.deleteById(caseId);
    }
}
