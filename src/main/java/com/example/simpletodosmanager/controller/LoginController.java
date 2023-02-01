package com.example.simpletodosmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 1/2/2023
 * @Description:
 */

@Controller
public class LoginController {
    @GetMapping("/login")
    String showLoginForm() {
        //login form is submitted using POST method <form th:action="@{/login}" method="post">
        return "forms/login";
    }
}
