package com.example.simpletodosmanager.dataloader;

import com.example.simpletodosmanager.model.*;
import com.example.simpletodosmanager.service.RoleService;
import com.example.simpletodosmanager.service.TODOItemService;
import com.example.simpletodosmanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 1/2/2023
 * @Description:
 */
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private RoleService roleService;
    private TODOItemService todoItemService;
    private final Logger logger = LoggerFactory.getLogger(InitialDataLoader.class);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Value("${default.admin.name}")
    private String defaultAdminName;
    @Value("${default.admin.password}")
    private String defaultAdminPassword;

    @Autowired
    public InitialDataLoader(UserService userService, RoleService roleService, TODOItemService todoItemService) {
        this.userService = userService;
        this.roleService = roleService;
        this.todoItemService = todoItemService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // Roles
        roleService.createRole(new Role(RoleName.ADMIN));
        roleService.createRole(new Role(RoleName.USER));
        roleService.findAll().stream().map(role -> "saved role: " + role.getName()).forEach(logger::info);


        // Users
        //1 Admin1
        User admin = new User(
                defaultAdminName,
                defaultAdminPassword);
        userService.createUser(admin);
        userService.changeRoleToAdmin(admin);

        //2 Admin2
        User manager = new User(
                "Manager",
                "112233");
        userService.createUser(manager);
        userService.changeRoleToAdmin(manager);

        //3
        userService.createUser(new User(
                "Anthony",
                "112233"));

        //4
        userService.createUser(new User(
                "Jacky",
                "112233"));

        //5
        userService.createUser(new User(
                "Jerry",
                "112233"));

        userService.findAll().stream()
                .map(u -> "saved user: " + u.getName())
                .forEach(logger::info);


        // To-Do items
        LocalDate today = LocalDate.now();

        // 1
        todoItemService.createItem(new TODOItem(
            "Do exercise",
                "Running for 10 minutes",
                today.plusDays(3),
                Status.InPROGRESS,
                "Anthony"
        ));

        // 2
        todoItemService.createItem(new TODOItem(
                "Read book",
                "12 rules for life, page 17-30",
                today.plusDays(2),
                Status.InPROGRESS,
                "Jacky"
        ));

        // 3
        todoItemService.createItem(new TODOItem(
                "Check all images and videos",
                "...",
                today.plusDays(1),
                Status.InPROGRESS,
                "Jerry"
        ));
    }

}
