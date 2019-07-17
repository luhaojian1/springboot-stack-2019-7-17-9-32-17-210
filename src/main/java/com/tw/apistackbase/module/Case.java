package com.tw.apistackbase.module;

import javax.persistence.*;

@Entity
@Table(name = "case")
public class Case {
    @Id
    @GeneratedValue
    private int caseId;

    @Column(nullable = false)
    private String caseName;

    @Column(nullable = false)
    private long occurrenceTime;

    @OneToOne
    @JoinColumn(name = "case_id" ,referencedColumnName = "id")
    private CrimeConstitution crimeConstitution;

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public long getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(long occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public CrimeConstitution getCrimeConstitution() {
        return crimeConstitution;
    }

    public void setCrimeConstitution(CrimeConstitution crimeConstitution) {
        this.crimeConstitution = crimeConstitution;
    }
}
