package com.example.simpletodosmanager.repository;

import com.example.simpletodosmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 31/1/2023
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);

}
