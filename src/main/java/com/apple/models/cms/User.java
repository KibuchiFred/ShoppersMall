package com.apple.models.cms;


import com.apple.models.shop.Shop;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "us_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String uuid;
    @NotEmpty(message = "First name can not be empty")
    private String us_fname;
    @NotBlank(message = "Username can not be left empty")
    private String us_lname;
    @NotBlank(message = "Email field can not be empty")
    @Email
    private String us_email;

    @NotBlank(message = "Please fill in the first name")
    private String us_username;

    @NotBlank(message = "Please fill in the password.")
    @Size(min = 6, max = 12, message = "password should be greater than 6")
    private String us_password;

    @NotBlank(message = "Retype the password")
    @Transient
    private String us_confirm_password;

    private String us_enabled;
    private Date created_at;
    private Date updated_at;
    private String created_by;
    private int updated_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public String getUs_confirm_password() {
        return us_confirm_password;
    }

    public void setUs_confirm_password(String us_confirm_password) {
        this.us_confirm_password = us_confirm_password;
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

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

}
