package com.tw.apistackbase;

import com.tw.apistackbase.module.Case;
import com.tw.apistackbase.module.CrimeConstitution;
import com.tw.apistackbase.repository.CaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;


    @Test
    public void should_save_and_find_case() {

        Case crimeCase = new Case();
        crimeCase.setCaseName("自杀");
        CrimeConstitution crimeConstitution = new CrimeConstitution();
        crimeConstitution.setObjectiveElement("2222");
        crimeConstitution.setSubjectiveElement("3333");
        crimeCase.setCrimeConstitution(crimeConstitution); //不用添加Id，由数据库自动生成

        Case case1 = caseRepository.save(crimeCase);
        Case targetCase = caseRepository.findById(case1.getCaseId()).get();

        assertThat("自杀").isEqualTo(targetCase.getCaseName());
        assertEquals(crimeConstitution.getObjectiveElement(), targetCase.getCrimeConstitution().getObjectiveElement());
    }

    @Test
    public void should_update_case() {

        Case crimeCase = new Case();
        crimeCase.setCaseName("自杀");
        CrimeConstitution crimeConstitution = new CrimeConstitution();
        crimeConstitution.setObjectiveElement("2222");
        crimeConstitution.setSubjectiveElement("3333");
        crimeCase.setCrimeConstitution(crimeConstitution);
        Case case1 = caseRepository.save(crimeCase);
        Case updateCase = caseRepository.findById(case1.getCaseId()).get();

        updateCase.setCaseName("他杀");
        updateCase.getCrimeConstitution().setObjectiveElement("4444");
        Case targetCase = caseRepository.save(updateCase);
        assertThat("他杀").isEqualTo(targetCase.getCaseName());
        assertEquals("4444", targetCase.getCrimeConstitution().getObjectiveElement());
    }

    @Test
    public void should_delete_case_by_id() {

        Case crimeCase = new Case();
        crimeCase.setCaseName("自杀");
        CrimeConstitution crimeConstitution = new CrimeConstitution();
        crimeConstitution.setObjectiveElement("2222");
        crimeConstitution.setSubjectiveElement("3333");
        crimeCase.setCrimeConstitution(crimeConstitution);
        Case case1 = caseRepository.save(crimeCase);

        caseRepository.deleteById(case1.getCaseId());
        Case targetCase = caseRepository.findById(case1.getCaseId()).orElse(null);

        assertNull(targetCase);
    }


}
