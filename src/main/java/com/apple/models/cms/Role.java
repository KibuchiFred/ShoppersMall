package com.apple.models.cms;

import javax.persistence.*;

@Entity
@Table(name = "ro_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rnRoleName")
    private String rnRoleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRnRoleName() {
        return rnRoleName;
    }

    public void setRnRoleName(String rnRoleName) {
        this.rnRoleName = rnRoleName;
    }
}
