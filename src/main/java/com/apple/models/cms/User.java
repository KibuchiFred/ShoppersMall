package com.apple.models.cms;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "us_users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String uuid;
    @NotEmpty(message = "First name can not be empty")
    @Column(name = "usFname")
    private String usFname;
    @NotBlank(message = "Username can not be left empty")
    @Column(name = "us_lname")
    private String usLname;
    @NotBlank(message = "Email field can not be empty")
    @Email
    @Column(name = "usEmail")
    private String usEmail;

    @NotBlank(message = "Please fill in the first name")
    @Column(name = "usUsername")
    private String usUsername;

    @NotBlank(message = "Please fill in the password.")
    @Size(min = 6, max = 12, message = "password should be greater than 6")
    @Column(name = "us_password")
    private String usPassword;

    @NotBlank(message = "Retype the password")
    @Transient
    private String usConfirmPassword;

    @Column(name = "us_enabled")
    private String usEnabled;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "updatedBy")
    private int updatedBy;

    public User(){}

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

    public String getUsFname() {
        return usFname;
    }

    public void setUsFname(String usFname) {
        this.usFname = usFname;
    }

    public String getUsLname() {
        return usLname;
    }

    public void setUsLname(String usLname) {
        this.usLname = usLname;
    }

    public String getUsEmail() {
        return usEmail;
    }

    public void setUsEmail(String usEmail) {
        this.usEmail = usEmail;
    }

    public String getUsUsername() {
        return usUsername;
    }

    public void setUsUsername(String usUsername) {
        this.usUsername = usUsername;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }
    public String getUsConfirmPassword() {
        return usConfirmPassword;
    }

    public void setUsConfirmPassword(String usConfirmPassword) {
        this.usConfirmPassword = usConfirmPassword;
    }

    public String getUsEnabled() {
        return usEnabled;
    }

    public void setUsEnabled(String usEnabled) {
        this.usEnabled = usEnabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

}
