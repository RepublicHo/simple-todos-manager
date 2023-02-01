package com.example.simpletodosmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 31/1/2023
 * @description:
 */

@Entity
public class TODOItem implements Serializable {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{task.description.not.empty}")
    private String itemName;

    @Size(max = 1200, message = "{task.description.size}")
    private String description;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dueDate;

    private Status status;

    private String creatorName;
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private User Owner;

    public TODOItem() {

    }
    public TODOItem(@NotBlank String itemName,
                    @Size(max = 1200) String description, LocalDate dueDate,
                    Status status, String creatorName) {
        this.itemName = itemName;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.creatorName = creatorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

        public String getItemName() {
        return itemName;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public User getOwner() {
        return Owner;
    }

    public void setOwner(User owner) {
        Owner = owner;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        TODOItem todoItem = (TODOItem) o;
        return todoItem.id == this.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

}
