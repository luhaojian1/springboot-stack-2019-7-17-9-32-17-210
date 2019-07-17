package com.tw.apistackbase.service;

import com.tw.apistackbase.module.Procurator;
import com.tw.apistackbase.repository.ProcuratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcuratorService {

    @Autowired
    private ProcuratorRepository procuratorRepository;

    public Procurator createProcurator(Procurator procurator) {
        return procuratorRepository.save(procurator);
    }

    public Optional<Procurator> findById(int procuratorId) {
        return procuratorRepository.findById(procuratorId);
    }
}
