package com.tw.apistackbase.module;

import javax.persistence.*;

@Entity
@Table(name = "crime_constitution")
public class CrimeConstitution {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String objectiveElement;

    @Column(nullable = false)
    private String subjectiveElement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjectiveElement() {
        return objectiveElement;
    }

    public void setObjectiveElement(String objectiveElement) {
        this.objectiveElement = objectiveElement;
    }

    public String getSubjectiveElement() {
        return subjectiveElement;
    }

    public void setSubjectiveElement(String subjectiveElement) {
        this.subjectiveElement = subjectiveElement;
    }
}
