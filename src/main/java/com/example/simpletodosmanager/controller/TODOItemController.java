package com.example.simpletodosmanager.controller;

import com.example.simpletodosmanager.exception.ResourceNotFoundException;
import com.example.simpletodosmanager.model.TODOItem;
import com.example.simpletodosmanager.model.User;
import com.example.simpletodosmanager.service.TODOItemService;
import com.example.simpletodosmanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;


/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 31/1/2023
 * @Description:
 */

@RestController
@RequestMapping("/api")

public class TODOItemController {

    private TODOItemService todoItemService;
    private UserService userService;

    public TODOItemController(TODOItemService todoItemService, UserService userService) {
        this.todoItemService = todoItemService;
        this.userService = userService;
    }

    @PostMapping("/todos")
    public String createToDoItem(@Valid @RequestBody TODOItem item){

        todoItemService.createItem(item);
        return "redirect:/todos";

    }


    @GetMapping("/todos")
    public String getToDoItems(Model model, Principal principal, SecurityContextHolderAwareRequestWrapper request){

        User signedUser = userService.getUserById(Long.parseLong(principal.getName()));
        boolean isAdminSigned = request.isUserInRole("ROLE_ADMIN");
        model.addAttribute("to-dos", todoItemService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("signedUser", signedUser);
        model.addAttribute("isAdminSigned", isAdminSigned);
        return "redirect:/todos";
    }

    @GetMapping("/todos/in-pogress")
    public String getToDoItemsInProgress(Model model, Principal principal, SecurityContextHolderAwareRequestWrapper request){

        User signedUser = userService.getUserById(Long.parseLong(principal.getName()));
        boolean isAdminSigned = request.isUserInRole("ROLE_ADMIN");
        model.addAttribute("onlyInProgress", true);
        model.addAttribute("to-dos", todoItemService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("signedUser", signedUser);
        model.addAttribute("isAdminSigned", isAdminSigned);
        return "redirect:/todos";
    }

    @GetMapping("/todos/completed")
    public String getToDoItemsCompleted(Model model, Principal principal, SecurityContextHolderAwareRequestWrapper request){

        User signedUser = userService.getUserById(Long.parseLong(principal.getName()));
        boolean isAdminSigned = request.isUserInRole("ROLE_ADMIN");
        model.addAttribute("onlyCompleted", true);
        model.addAttribute("to-dos", todoItemService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("signedUser", signedUser);
        model.addAttribute("isAdminSigned", isAdminSigned);
        return "redirect:/todos";
    }

    @GetMapping("/todos/overdue")
    public String getToDoItemsOverdue(Model model, Principal principal, SecurityContextHolderAwareRequestWrapper request){

        User signedUser = userService.getUserById(Long.parseLong(principal.getName()));
        boolean isAdminSigned = request.isUserInRole("ROLE_ADMIN");
        model.addAttribute("onlyOverdue", true);
        model.addAttribute("to-dos", todoItemService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("signedUser", signedUser);
        model.addAttribute("isAdminSigned", isAdminSigned);
        return "redirect:/todos";
    }


    @PostMapping("/todos/edit/{id}")
    public String updateToDoItem(@PathVariable(value = "id") Long itemId, @Valid @RequestBody TODOItem requestItem){

        // TODO: some unexpected cases should be considered here.
        todoItemService.updateItem(itemId, requestItem);
        return "redirect:/todos";

    }

    @GetMapping("/todos/delete/{id}")
    public String deleteToDoItem(@PathVariable(value = "id") Long itemId){
        todoItemService.deleteItem(itemId);
        return "redirect:/todos";
    }




}
