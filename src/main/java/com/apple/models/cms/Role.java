package com.apple.models.cms;

import javax.persistence.*;

@Entity
@Table(name = "ro_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rn_role_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRn_role_name() {
        return rn_role_name;
    }

    public void setRn_role_name(String rn_role_name) {
        this.rn_role_name = rn_role_name;
    }
}
