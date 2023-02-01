package com.example.simpletodosmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author Anthony HE, anthony.zj.he@outlook.com
 * @Date 31/1/2023
 * @Description:
 */

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank(message = "{user.name.not.empty}")
    @Size(max = 40)
    private String name;

    @NotBlank(message = "{user.password.not.empty}")
    @Length(min = 5, message = "{user.password.length}")
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private Set<TODOItem> todoItemOwned;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User() {}
    public User(@NotBlank String name, @NotBlank @Length(min = 5) String password) {
        this.name = name;
        this.password = password;
    }
    public User(@NotBlank String name, @NotBlank @Length(min = 5) String password,
                Set<TODOItem> todoItemOwned, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.todoItemOwned = todoItemOwned;
        this.roles = roles;
    }


    public Set<TODOItem> getTodoItemCompleted(){
        return todoItemOwned.stream()
                .filter(todoItem -> todoItem.getStatus() == Status.COMPLETED)
                .collect(Collectors.toSet());
    }
    public Set<TODOItem> getTodoItemOverdue(){
        return todoItemOwned.stream()
                .filter(todoItem -> todoItem.getStatus() == Status.OVERDUE)
                .collect(Collectors.toSet());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TODOItem> getTodoItemOwned() {
        return todoItemOwned;
    }

    public void setTodoItemOwned(Set<TODOItem> todoItemOwned) {
        this.todoItemOwned = todoItemOwned;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<TODOItem> getTodoItemInProgress(){
        return todoItemOwned.stream()
                .filter(todoItem -> todoItem.getStatus() == Status.InPROGRESS)
                .collect(Collectors.toSet());
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.id == user.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
