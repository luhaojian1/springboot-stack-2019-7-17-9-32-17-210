package com.tw.apistackbase.service;

import com.tw.apistackbase.module.Case;
import com.tw.apistackbase.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseService {
    @Autowired
    private CaseRepository caseRepository;

    public Case createCase(Case caseInfo) {
        caseInfo.setOccurrenceTime(System.currentTimeMillis());
        return caseRepository.save(caseInfo);
    }
}
