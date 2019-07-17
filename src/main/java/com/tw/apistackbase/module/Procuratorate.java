package com.tw.apistackbase.module;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "procuratorate")
public class Procuratorate {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 50)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
