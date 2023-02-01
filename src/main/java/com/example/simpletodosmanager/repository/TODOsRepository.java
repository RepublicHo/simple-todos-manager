package com.example.simpletodosmanager.repository;

import com.example.simpletodosmanager.model.TODOItem;
import com.example.simpletodosmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 31/1/2023
 * @Description: the to-do items can only be found
 * by their owner.
 */
public interface TODOsRepository extends JpaRepository<TODOItem, Long> {
    Optional<TODOItem> findByItemName(String name);
    List<TODOItem> findByOwnerOrderByDateDesc(User user);



}
