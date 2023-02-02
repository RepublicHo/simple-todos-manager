package com.example.simpletodosmanager.service;

import com.example.simpletodosmanager.exception.ResourceNotFoundException;
import com.example.simpletodosmanager.model.Status;
import com.example.simpletodosmanager.model.TODOItem;
import com.example.simpletodosmanager.model.User;
import com.example.simpletodosmanager.repository.TODOsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 1/2/2023
 * @Description:
 */
@Service
public class TODOItemServiceImpl implements TODOItemService{
    private TODOsRepository repository;

    @Autowired
    public TODOItemServiceImpl(TODOsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createItem(TODOItem item) {
        repository.save(item);
    }

    @Override
    public void updateItem(Long id, TODOItem item) {
        TODOItem todoItem = repository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Item", "id", id));

        todoItem.setItemName(item.getItemName());
        todoItem.setDescription(item.getDescription());
        todoItem.setDueDate(item.getDueDate());
        repository.save(todoItem);
    }

    @Override
    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TODOItem> findAll() {
        return repository.findAll();
    }

    @Override
    public List<TODOItem> findByOwnerOrderByDueDateDesc(User user) {
        return repository.findByOwnerOrderByDueDateDesc(user);
    }

    @Override
    public void setItemInProgress(Long id) {
        TODOItem todoItem = repository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Item", "id", id));
        todoItem.setStatus(Status.InPROGRESS);
        repository.save(todoItem);
    }

    @Override
    public void setItemOverdue(Long id) {
        TODOItem todoItem = repository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Item", "id", id));
        todoItem.setStatus(Status.OVERDUE);
        repository.save(todoItem);
    }

    @Override
    public void setItemCompleted(Long id) {
        TODOItem todoItem = repository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Item", "id", id));
        todoItem.setStatus(Status.COMPLETED);
        repository.save(todoItem);
    }

    @Override
    public List<TODOItem> getFreeItems() {
        return repository.findAll()
                .stream()
                .filter(todoItem -> todoItem.getOwner() == null &&
                        todoItem.getStatus() == Status.InPROGRESS)
                .collect(Collectors.toList());
    }

    @Override
    public void assignItemToUser(TODOItem item, User user) {
        item.setOwner(user);
        repository.save(item);
    }

    @Override
    public void freeItem(TODOItem item) {
        item.setCreatorName(null);
        repository.save(item);
    }

}
