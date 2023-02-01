package com.example.simpletodosmanager.service;

import com.example.simpletodosmanager.model.Role;
import com.example.simpletodosmanager.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 1/2/2023
 * @Description:
 */

@Service
public class RoleServiceImpl implements RoleService{
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.roleRepository = repository;
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
