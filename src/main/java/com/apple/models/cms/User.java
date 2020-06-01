package com.apple.models.cms;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "us_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@NotBlank
    private String uuid;
@NotBlank(message = "First name can not be empty")
    private String us_fname;
@NotBlank(message = "Username can not be left empty")
    private String us_lname;
@NotBlank(message = "Email field can not be empty")
@Email
    private String us_email;

    @NotBlank(message = "Please fill in the first name")
    private String us_username;

@NotBlank(message = "Please fill in the password.")
    private String us_password;

    private String us_enabled;
    private Date created_at;
    private Date updated_at;
    private int created_by;
    private int updated_by;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUs_fname() {
        return us_fname;
    }

    public void setUs_fname(String us_fname) {
        this.us_fname = us_fname;
    }

    public String getUs_lname() {
        return us_lname;
    }

    public void setUs_lname(String us_lname) {
        this.us_lname = us_lname;
    }

    public String getUs_email() {
        return us_email;
    }

    public void setUs_email(String us_email) {
        this.us_email = us_email;
    }

    public String getUs_username() {
        return us_username;
    }

    public void setUs_username(String us_username) {
        this.us_username = us_username;
    }

    public String getUs_password() {
        return us_password;
    }

    public void setUs_password(String us_password) {
        this.us_password = us_password;
    }

    public String getUs_enabled() {
        return us_enabled;
    }

    public void setUs_enabled(String us_enabled) {
        this.us_enabled = us_enabled;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

}
