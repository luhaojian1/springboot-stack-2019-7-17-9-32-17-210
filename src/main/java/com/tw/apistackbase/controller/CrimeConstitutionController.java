package com.tw.apistackbase.controller;

import com.tw.apistackbase.module.CrimeConstitution;
import com.tw.apistackbase.service.CrimeConstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CrimeConstitutionController {
    @Autowired
    private CrimeConstitutionService crimeConstitutionService;
    @PostMapping("/crimeConstitutions")
    public CrimeConstitution createCrimeConstitution(@RequestBody CrimeConstitution crimeConstitution){
        return crimeConstitutionService.createCrimeConstitution(crimeConstitution);
    }

    @GetMapping("/crimeConstitutions")
    public List<CrimeConstitution> findAllCrimeConstitution(){
        return crimeConstitutionService.findAllCrimeConstitution();
    }

    @GetMapping("/crimeConstitutions/{crimeConstitutionId}")
    public Optional<CrimeConstitution> findCrimeConstitutionById(@PathVariable int crimeConstitutionId){
        return crimeConstitutionService.findById(crimeConstitutionId);
    }


}
