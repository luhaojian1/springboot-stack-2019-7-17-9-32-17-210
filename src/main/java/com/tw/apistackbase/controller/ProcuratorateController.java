package com.tw.apistackbase.controller;

import com.tw.apistackbase.module.Procurator;
import com.tw.apistackbase.module.Procuratorate;
import com.tw.apistackbase.service.ProcuratorateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProcuratorateController {
    @Autowired
    private ProcuratorateService procuratorateService;

    @PostMapping("/procuratorates")
    public Procuratorate createProcuratorate(@RequestBody Procuratorate procuratorate) {
        return procuratorateService.createProcuratorate(procuratorate);
    }

    @GetMapping("/procuratorates/(procuratorateId)")
    public Optional<Procuratorate> findProcuratorateById(@RequestBody int procuratorateId) {
        return procuratorateService.findById(procuratorateId);
    }
}
