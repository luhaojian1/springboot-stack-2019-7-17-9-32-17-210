package com.tw.apistackbase;

import com.tw.apistackbase.module.Case;
import com.tw.apistackbase.module.CrimeConstitution;
import com.tw.apistackbase.repository.CaseRepository;
import com.tw.apistackbase.repository.CrimeConstitutionRepository;
import com.tw.apistackbase.service.CaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private CrimeConstitutionRepository crimeConstitutionRepository;

    @Test
    public void should_save_and_find_case(){

        Case crimeCase = new Case();
        crimeCase.setCaseName("自杀");
        CrimeConstitution crimeConstitution = new CrimeConstitution();
        crimeConstitution.setObjectiveElement("2222");
        crimeConstitution.setSubjectiveElement("3333");
        crimeCase.setCrimeConstitution(crimeConstitution); //不用添加Id，由数据库自动生成

        Case case1 =caseRepository.save(crimeCase);
        Case targetCase = caseRepository.findById(case1.getCaseId()).get();

        assertThat("自杀").isEqualTo(targetCase.getCaseName());
        assertEquals(crimeConstitution.getObjectiveElement(),targetCase.getCrimeConstitution().getObjectiveElement());
    }

}
