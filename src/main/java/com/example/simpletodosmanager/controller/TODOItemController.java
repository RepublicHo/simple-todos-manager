package com.example.simpletodosmanager.controller;

import com.example.simpletodosmanager.exception.ResourceNotFoundException;
import com.example.simpletodosmanager.model.TODOItem;
import com.example.simpletodosmanager.service.TODOItemService;
import com.example.simpletodosmanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    @PostMapping("/todos")
//    public TODOItem createToDoItem(@Valid @RequestBody TODOItem item){
//        return toDosRepository.save(item);
//    }

//    @GetMapping("/todos")
//    public List<TODOItem> getAllToDoItems(){
//        // sort by the due date
//        return toDosRepository.findAll(Sort.by(Sort.Direction.ASC, "dueDate"));
//    }
//
//    @PostMapping("/todos/{id}")
//    public TODOItem getToDoItemById(@PathVariable(value = "id") Long itemId){
//        return toDosRepository.findById(itemId)
//                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));
//    }
//    @PostMapping("/todos/{name}")
//    public Optional<TODOItem> getToDoItemByItemName(@PathVariable(value = "name") String name){
//        return Optional.ofNullable(toDosRepository.findByItemName(name)
//                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", name)));
//    }


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
