//package com.apple.models.cms;
//
//import com.apple.models.shop.Shop;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
////@Embeddable
//public class UserRoleShop  {
//    @Id
//    private Long id;
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "us_fk")
//    private User user;
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "ro_fk")
//    private Role role;
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "sh_fk")
//    private Shop shop;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public Shop getShop() {
//        return shop;
//    }
//
//    public void setShop(Shop shop) {
//        this.shop = shop;
//    }
//
//    public UserRoleShop(User user, Role role, Shop shop) {
//        this.user = user;
//        this.role = role;
//        this.shop = shop;
//    }
//
//    public UserRoleShop() {
//    }
//
//}
