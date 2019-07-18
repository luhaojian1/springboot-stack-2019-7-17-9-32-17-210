package com.tw.apistackbase.repository;

import com.tw.apistackbase.module.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Integer> {

    public List<Case> findByCaseName(String caseName);

    public List<Case> findAllByOrderByOccurrenceTimeDesc();

}
