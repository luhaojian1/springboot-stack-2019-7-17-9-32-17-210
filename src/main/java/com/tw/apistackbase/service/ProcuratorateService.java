package com.tw.apistackbase.service;

import com.tw.apistackbase.module.Procurator;
import com.tw.apistackbase.module.Procuratorate;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcuratorateService {

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    public Procuratorate createProcuratorate(Procuratorate procuratorate) {
        return procuratorateRepository.save(procuratorate);
    }

    public Optional<Procuratorate> findById(int procuratorateId) {
        return procuratorateRepository.findById(procuratorateId);
    }


}
