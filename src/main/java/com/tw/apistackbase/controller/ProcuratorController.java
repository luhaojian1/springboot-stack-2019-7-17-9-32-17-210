package com.tw.apistackbase.controller;

import com.tw.apistackbase.module.Procurator;
import com.tw.apistackbase.service.ProcuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProcuratorController {
    @Autowired
    private ProcuratorService procuratorService;

    @PostMapping("/procurators")
    public Procurator createProcurator(@RequestBody Procurator procurator) {
        return procuratorService.createProcurator(procurator);
    }

    @GetMapping("/procurators/(procuratorId)")
    public Optional<Procurator> findProcuratorById(@RequestBody int procuratorId) {
        return procuratorService.findById(procuratorId);
    }
}
