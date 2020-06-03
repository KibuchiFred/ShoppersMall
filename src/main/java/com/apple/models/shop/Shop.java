package com.apple.models.shop;

import com.apple.models.cms.Role;
import com.apple.models.cms.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "sh_shops")
public class Shop {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Shop name can not be left blank")
    private String sh_name;

    @NotBlank(message = "please provide shop icon")
    private String sh_icon;

    @NotBlank(message = "please fill the shop description")
    private String sh_description;

    @NotBlank
    private String sh_tag;

    @NotBlank
    private String uuid;

    private String created_at;
    private String updated_at;
    private String created_by;
    private String updated_by;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSh_name() {
        return sh_name;
    }

    public void setSh_name(String sh_name) {
        this.sh_name = sh_name;
    }

    public String getSh_icon() {
        return sh_icon;
    }

    public void setSh_icon(String sh_icon) {
        this.sh_icon = sh_icon;
    }

    public String getSh_description() {
        return sh_description;
    }

    public void setSh_description(String sh_description) {
        this.sh_description = sh_description;
    }

    public String getSh_tag() {
        return sh_tag;
    }

    public void setSh_tag(String sh_tag) {
        this.sh_tag = sh_tag;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
}
