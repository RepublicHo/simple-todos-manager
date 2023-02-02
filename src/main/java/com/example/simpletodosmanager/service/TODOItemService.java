package com.example.simpletodosmanager.service;

import com.example.simpletodosmanager.model.TODOItem;
import com.example.simpletodosmanager.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 1/2/2023
 * @Description:
 */
public interface TODOItemService {
    void createItem(TODOItem item);
    void updateItem(Long id, TODOItem item);
    void deleteItem(Long id);
    List<TODOItem> findAll();

    List<TODOItem> findByOwnerOrderByDueDateDesc(User user);

    void setItemInProgress(Long id);
    void setItemOverdue(Long id);
    void setItemCompleted(Long id);

    List<TODOItem> getFreeItems();
    void assignItemToUser(TODOItem item, User user);
    void freeItem(TODOItem item);

}
