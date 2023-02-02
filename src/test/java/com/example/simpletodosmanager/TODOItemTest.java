package com.example.simpletodosmanager;

import com.example.simpletodosmanager.model.TODOItem;
import com.example.simpletodosmanager.model.User;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 2/2/2023
 * @Description:
 */
public class TODOItemTest {
    TODOItem item1, item2;

    @BeforeEach
    void setUp(){
        item1 = new TODOItem(new Long(1231), "item1", "sleep", LocalDate.now(), "Anthony", new User("Anthony", "1234567"));
        item2 = new TODOItem(new Long(1232), "item2", "have dinner", LocalDate.now(), "Jerry", new User("Jerry", "123456"));

    }
}
