//package com.apple.models.cms;
//
//import com.apple.models.shop.Shop;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user_shop_role")
//public class UserShopRoleCollaborator {
//    //this is by using a surrogate/artificial id
//    //it's the modern and better way of doing it
//    //source:- https://stackoverflow.com/questions/42488559/manytomany-relationship-between-three-tables
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    //this is unidirectional in the meantime
//
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
//    @JoinColumn(name = "user_fk", nullable = false)
//    private User user;
//
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
//    @JoinColumn(name = "shop_fk", nullable = false)
//    private Shop shop;
//
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
//    @JoinColumn(name = "role_fk", nullable = false)
//    private Role role;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
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
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//
//    //using composite key method would be
//    /*
//    @EmbeddedId
//    private UserShopRolePK compKey = new UserShopRolePK();
//
//    public UserShopRolePK getCompKey() {
//        return compKey;
//    }
//
//    public void setCompKey(UserShopRolePK compKey) {
//        this.compKey = compKey;
//    }
//
//    @Transient
//    public User getUser(){
//        return getCompKey().getUser();
//    }
//
//    @Transient
//    private Shop getShop(){
//        return getCompKey().getShop();
//    }
//
//    @Transient
//    private Role getRole(){
//        return getCompKey().getRole();
//    }
//
//     */
//
//}
