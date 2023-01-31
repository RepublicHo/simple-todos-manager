package com.example.simpletodosmanager.repository;

import com.example.simpletodosmanager.model.TODOItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 31/1/2023
 * @Description:
 */
public interface TODOsRepository extends JpaRepository<TODOItem, Long> {


}
