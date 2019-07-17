package com.tw.apistackbase.controller;

import com.tw.apistackbase.module.Case;
import com.tw.apistackbase.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CaseController {
    @Autowired
    private CaseService caseService;

    @PostMapping("/cases")
    public Case createCase(@RequestBody Case caseInfo){
        return caseService.createCase(caseInfo);
    }
}
