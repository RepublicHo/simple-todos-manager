package com.example.simpletodosmanager;

import com.example.simpletodosmanager.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 2/2/2023
 * @Description:
 */
public class UserTest {
    User Anthony, Jerry;

    @BeforeEach
    void setUp(){
        Anthony = new User("Anthony", "1234567");
        Jerry = new User("Jerry", "1234567");
    }

    @Test
    void testEqualHash(){

    }




}
