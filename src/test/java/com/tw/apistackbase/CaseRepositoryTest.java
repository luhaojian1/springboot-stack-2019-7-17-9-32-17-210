package com.tw.apistackbase;

import com.tw.apistackbase.module.Case;
import com.tw.apistackbase.module.CrimeConstitution;
import com.tw.apistackbase.module.Procuratorate;
import com.tw.apistackbase.repository.CaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.yml")
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

        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setName("检察院1");


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

    @Test
    public void should_find_cases_by_caseName() {

        Case crimeCase = new Case();
        crimeCase.setCaseName("自杀");
        CrimeConstitution crimeConstitution = new CrimeConstitution();
        crimeConstitution.setObjectiveElement("2222");
        crimeConstitution.setSubjectiveElement("3333");
        crimeCase.setCrimeConstitution(crimeConstitution);
        caseRepository.save(crimeCase);

        Case crimeCase1 = new Case();
        crimeCase1.setCaseName("自杀");
        CrimeConstitution crimeConstitution1 = new CrimeConstitution();
        crimeConstitution1.setObjectiveElement("2222");
        crimeConstitution1.setSubjectiveElement("4444");
        crimeCase1.setOccurrenceTime(System.currentTimeMillis());
        crimeCase1.setCrimeConstitution(crimeConstitution1);
        caseRepository.save(crimeCase1);

        List<Case> cases = caseRepository.findByCaseName("自杀");
        assertEquals(cases.size(), 2);
    }

    @Test
    public void should_get_cases_list_order_by_time() {
        Case crimeCase = new Case();
        crimeCase.setCaseName("自杀");
        CrimeConstitution crimeConstitution = new CrimeConstitution();
        crimeConstitution.setObjectiveElement("2222");
        crimeConstitution.setSubjectiveElement("3333");
        crimeCase.setOccurrenceTime(System.currentTimeMillis());
        crimeCase.setCrimeConstitution(crimeConstitution);
        caseRepository.save(crimeCase);

        Case crimeCase1 = new Case();
        crimeCase1.setCaseName("他杀");
        CrimeConstitution crimeConstitution1 = new CrimeConstitution();
        crimeConstitution1.setObjectiveElement("2222");
        crimeConstitution1.setSubjectiveElement("3333");
        crimeCase1.setOccurrenceTime(System.currentTimeMillis());
        crimeCase1.setCrimeConstitution(crimeConstitution1);
        caseRepository.save(crimeCase1);

        List<Case> cases = caseRepository.findAllByOrderByOccurrenceTimeDesc();
        assertEquals("他杀", cases.get(0).getCaseName());
        assertEquals("自杀", cases.get(1).getCaseName());
    }


}
