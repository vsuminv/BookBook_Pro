package com.proj.bookbook.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long role_id;

    @Column(name="role_name")
    private String role_name;

    public enum UserRole {
        USER, ADMIN;

    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> userList = new ArrayList<>();


}