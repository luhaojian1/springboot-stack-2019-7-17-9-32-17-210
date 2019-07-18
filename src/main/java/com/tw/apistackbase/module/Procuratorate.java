package com.tw.apistackbase.module;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "procuratorate")
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, length = 50)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "procuratorate_id")
    private List<Procurator> procurators;

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

    public List<Procurator> getProcurators() {
        return procurators;
    }

    public void setProcurators(List<Procurator> procurators) {
        this.procurators = procurators;
    }
}
