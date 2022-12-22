package com.mtuci.spring_app.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer permissionLevel;

    @OneToMany(mappedBy="role")
    private Set<User> users;

    public Role() {
    }

    public Role(Integer id, String name, Integer permissionLevel) {
        this.id = id;
        this.name = name;
        this.permissionLevel = permissionLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permission_level) {
        this.permissionLevel = permission_level;
    }

    @PreRemove
    public void setUserRolesToNull() {
        users.forEach(user -> user.setRole(null));
    }
}
