package com.example.simpletodosmanager.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.Set;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 31/1/2023
 * @Description:
 */

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60, name = "role")
    private RoleName name;


    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {

    }

    public Role(RoleName name) {
        this.name = name;
    }
    public Role(RoleName name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

