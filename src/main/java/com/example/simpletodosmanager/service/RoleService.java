package com.example.simpletodosmanager.service;

import com.example.simpletodosmanager.model.Role;

import java.util.List;


/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 1/2/2023
 * @Description:
 */
public interface RoleService {

    Role createRole(Role role);
    List<Role> findAll();
}
