package com.example.simpletodosmanager.repository;

import com.example.simpletodosmanager.model.TODOItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 31/1/2023
 * @Description:
 */
public interface TODOsRepository extends JpaRepository<TODOItem, Long> {
    Optional<TODOItem> findByItemName(String name);
    Optional<TODOItem> findByDueDate(Date date);



}
