package com.proj.bookbook.DTO;


import com.proj.bookbook.Model.Role;
import com.proj.bookbook.Model.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private Long role_id;
    private String role_name;

    private List<User> userList;

    public RoleDTO(Role role){
        this.role_id = role.getRole_id();
        this.role_name = role.getRole_name();
        this.userList = role.getUserList();

    }
}