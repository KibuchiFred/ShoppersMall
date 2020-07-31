package com.apple.models.cms;


import com.apple.models.shop.Shop;
import com.apple.validators.ValidEmail;
import com.apple.validators.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "us_users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Basic(fetch = FetchType.LAZY, optional = false)
    private String uuid;
    @NotBlank(message = "First name can not be empty")
    @Column(name = "usFname")
    private String usFname;
    @NotBlank(message = "Username can not be left empty")
    @Column(name = "us_lname")
    private String usLname;
    @NotBlank(message = "Email field can not be empty")
    //@Email
    @ValidEmail
    @Column(name = "usEmail", unique = true)
    @Basic(fetch = FetchType.LAZY, optional = false)
    private String usEmail;

    @NotBlank(message = "Please fill in the user name")
    @Column(name = "usUsername")
    @Size(min = 6, max = 20, message = "Username should be greater than 6")
    @Basic(fetch = FetchType.LAZY, optional = false)
    private String usUsername;

//    @NotBlank(message = "Please fill in the password.")
//    @Size(min = 6, max = 20, message = "password should be greater than 6")
//    @Column(name = "us_password")
    @Basic(fetch = FetchType.LAZY, optional = false)
    @ValidPassword
    private String usPassword;

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
    private String updatedBy;

    //mapping
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "user_shop_role",
            joinColumns = @JoinColumn(name = "user_fk"), inverseJoinColumns = @JoinColumn(name = "role_fk"))
    @MapKeyJoinColumn(name = "shop_fk")
    private Map<Shop, Role> shopRoleMap = new HashMap<>();

    public User(String uuid, @NotBlank(message = "First name can not be empty") String usFname, @NotBlank(message = "Username can not be left empty") String usLname, @NotBlank(message = "Email field can not be empty") String usEmail, @NotBlank(message = "Please fill in the user name") @Size(min = 6, max = 20, message = "Username should be greater than 6") String usUsername, String usPassword, String usConfirmPassword, String usEnabled, LocalDateTime createdAt,
                LocalDateTime updatedAt, String createdBy, String updatedBy, Map<Shop, Role> shopRoleMap) {
        this.uuid = uuid;
        this.usFname = usFname;
        this.usLname = usLname;
        this.usEmail = usEmail;
        this.usUsername = usUsername;
        this.usPassword = usPassword;
        this.usConfirmPassword = usConfirmPassword;
        this.usEnabled = usEnabled;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.shopRoleMap = shopRoleMap;
    }

    public Map<Shop, Role> getShopRoleMap() {
        return shopRoleMap;
    }

    public void setShopRoleMap(Map<Shop, Role> shopRoleMap) {
        this.shopRoleMap = shopRoleMap;
    }

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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getUuid().equals(user.getUuid()) &&
                getUsFname().equals(user.getUsFname()) &&
                getUsLname().equals(user.getUsLname()) &&
                getUsEmail().equals(user.getUsEmail()) &&
                getUsUsername().equals(user.getUsUsername()) &&
                getUsPassword().equals(user.getUsPassword()) &&
                Objects.equals(getUsConfirmPassword(), user.getUsConfirmPassword()) &&
                getUsEnabled().equals(user.getUsEnabled()) &&
                Objects.equals(getCreatedAt(), user.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), user.getUpdatedAt()) &&
                getCreatedBy().equals(user.getCreatedBy()) &&
                Objects.equals(getUpdatedBy(), user.getUpdatedBy()) &&
                getShopRoleMap().equals(user.getShopRoleMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUuid(), getUsFname(), getUsLname(), getUsEmail(), getUsUsername(), getUsPassword(), getUsConfirmPassword(), getUsEnabled(), getCreatedAt(), getUpdatedAt(), getCreatedBy(), getUpdatedBy(), getShopRoleMap());
    }
}
