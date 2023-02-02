package com.example.simpletodosmanager.service;

import com.example.simpletodosmanager.exception.ResourceNotFoundException;
import com.example.simpletodosmanager.model.Role;
import com.example.simpletodosmanager.model.RoleName;
import com.example.simpletodosmanager.model.User;
import com.example.simpletodosmanager.repository.RoleRepository;
import com.example.simpletodosmanager.repository.TODOsRepository;
import com.example.simpletodosmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 1/2/2023
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private TODOsRepository toDosRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TODOsRepository toDosRepository,
                           RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.toDosRepository = toDosRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRoleName(RoleName.USER);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    @Override
    public User changeRoleToAdmin(User user) {
        Role adminRole = roleRepository.findByRoleName(RoleName.ADMIN);
        user.setRoles(new HashSet<>(Arrays.asList(adminRole)));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() ->  new ResourceNotFoundException("User", "id", userId));
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->  new ResourceNotFoundException("User", "id", userId));
        user.getTodoItemOwned().forEach(todoItem -> todoItem.setOwner(null));
        userRepository.deleteById(userId);
    }
}
