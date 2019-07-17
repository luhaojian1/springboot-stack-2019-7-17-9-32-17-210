package com.tw.apistackbase.module;

import javax.persistence.*;

@Entity
@Table(name = "crime_constitution")
public class CrimeConstitution {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String subjectiveElement;

    @Column(nullable = false)
    private String objectiveElement;

    @OneToOne(mappedBy = "crimeConstitution")
    private Case crimeCase;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectiveElement() {
        return subjectiveElement;
    }

    public void setSubjectiveElement(String subjectiveElement) {
        this.subjectiveElement = subjectiveElement;
    }

    public String getObjectiveElement() {
        return objectiveElement;
    }

    public void setObjectiveElement(String objectiveElement) {
        this.objectiveElement = objectiveElement;
    }
}

