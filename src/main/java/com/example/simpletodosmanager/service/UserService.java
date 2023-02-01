package com.example.simpletodosmanager.service;

import com.example.simpletodosmanager.model.User;

import java.util.List;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 1/2/2023
 * @Description:
 */
public interface UserService {
    User createUser(User user);

    User changeRoleToAdmin(User user);

    List<User> findAll();

    User getUserById(Long userId);

    void deleteUser(Long id);
}
