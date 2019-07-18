package com.tw.apistackbase;

import com.tw.apistackbase.module.CrimeConstitution;
import com.tw.apistackbase.repository.CrimeConstitutionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CrimeConsititutionRepository {

    @Autowired
    private CrimeConstitutionRepository crimeConstitutionRepository;

    @Test
    public void should_save_and_find_crimeConstitution() {


        CrimeConstitution crimeConstitution = new CrimeConstitution();
        crimeConstitution.setObjectiveElement("2222");
        crimeConstitution.setSubjectiveElement("3333");

        CrimeConstitution crimeConstitution1 = crimeConstitutionRepository.save(crimeConstitution);
        CrimeConstitution targetCrimeConstitution = crimeConstitutionRepository.findById(crimeConstitution1.getId()).get();

        assertThat("2222").isEqualTo(targetCrimeConstitution.getObjectiveElement());
        assertEquals(targetCrimeConstitution.getSubjectiveElement(), "3333");
    }


}
