package com.tw.apistackbase.module;

import javax.persistence.*;

@Entity
@Table(name = "procurator")
public class Procurator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int procuratorId;
    @Column(nullable = false)
    private String procuratorName;

    public int getProcuratorId() {
        return procuratorId;
    }

    public void setProcuratorId(int procuratorId) {
        this.procuratorId = procuratorId;
    }

    public String getProcuratorName() {
        return procuratorName;
    }

    public void setProcuratorName(String procuratorName) {
        this.procuratorName = procuratorName;
    }
}
