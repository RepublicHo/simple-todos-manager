package com.example.simpletodosmanager.model;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 31/1/2023
 * @Description: Todo item status.
 */
public enum Status {
    DONE, // the item has been done by the due date
    OVERDUE, // the item has not been done by the due date
    TODO // the item has not been done, but it hasn't reached the due date.
}
