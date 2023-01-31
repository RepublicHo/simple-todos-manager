package com.example.simpletodosmanager.controller;

import com.example.simpletodosmanager.exception.ResourceNotFoundException;
import com.example.simpletodosmanager.model.TODOItem;
import com.example.simpletodosmanager.repository.TODOsRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 31/1/2023
 * @Description:
 */

@RestController
@RequestMapping("/api")
public class TODOsController {

    TODOsRepository toDosRepository;

    @GetMapping("/todos")
    public List<TODOItem> getAllToDoItems(){
        return toDosRepository.findAll();
    }

    @PostMapping("/todos")
    public TODOItem createToDoItem(@Valid @RequestBody TODOItem item){
        return toDosRepository.save(item);
    }
    @PostMapping("/todos/{id}")
    public TODOItem getToDoItemById(@PathVariable(value = "id") Long itemId){
        return toDosRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));
    }
    @PostMapping("/todos/{name}")
    public Optional<TODOItem> getToDoItemByItemName(@PathVariable(value = "name") String name){
        return Optional.ofNullable(toDosRepository.findByItemName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", name)));
    }

    @PostMapping("/todos/{date}")
    public Optional<TODOItem> getToDoItemByDueDate(@PathVariable(value = "date") Date date){
        return Optional.ofNullable(toDosRepository.findByDueDate(date)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", date)));
    }

    @PutMapping("/todos/{id}")
    public TODOItem updateToDoItem(@PathVariable(value = "id") Long itemId, @Valid @RequestBody TODOItem requestItem){

        TODOItem todoItem = toDosRepository.findById(itemId)
                .orElseThrow(() ->  new ResourceNotFoundException("Item", "id", itemId));

        todoItem.setItemName(requestItem.getItemName());
        todoItem.setDescription(requestItem.getDescription());
        todoItem.setLastModifiedDate(requestItem.getLastModifiedDate());
        todoItem.setDueDate(requestItem.getDueDate());

        TODOItem updatedItem = toDosRepository.save(todoItem);
        return updatedItem;
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteToDoItem(@PathVariable(value = "id") Long itemId){
        TODOItem todoItem = toDosRepository.findById(itemId)
                .orElseThrow(() ->  new ResourceNotFoundException("Note", "id", itemId));
        toDosRepository.delete(todoItem);
        return ResponseEntity.ok().build();
    }


}
