package com.tw.apistackbase.controller;

import com.tw.apistackbase.module.Case;
import com.tw.apistackbase.module.CrimeConstitution;
import com.tw.apistackbase.service.CrimeConstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrimeConstitutionController {
    @Autowired
    private CrimeConstitutionService crimeConstitutionService;
    @PostMapping("/crimeConstitutions")
    public CrimeConstitution createCrimeConstitution(@RequestBody CrimeConstitution crimeConstitution){
        return crimeConstitutionService.createCrimeConstitution(crimeConstitution);
    }

}
