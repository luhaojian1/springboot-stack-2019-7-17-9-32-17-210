package com.tw.apistackbase.controller;

import com.tw.apistackbase.module.Case;
import com.tw.apistackbase.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CaseController {
    @Autowired
    private CaseService caseService;

    @PostMapping("/cases")
    public Case createCase(@RequestBody Case caseInfo){
        return caseService.createCase(caseInfo);
    }

    @GetMapping("/cases")
    public List<Case> findAllCasesOrderByTime(){
        return caseService.findAllCasesOrderByTime();
    }

    @GetMapping("/cases/{caseId}")
    public Optional<Case> findById(@PathVariable int caseId){
        return caseService.findById(caseId);
    }

    @GetMapping(value = "/cases",params = "caseName")
    public List<Case> findByCaseName(@RequestParam String caseName){
        return caseService.findByCaseName(caseName);
    }

    @DeleteMapping(value = "/cases/{caseId}")
    public void deleteByCaseId(@PathVariable int caseId){
        caseService.deleteById(caseId);
    }

}
