package com.proj.bookbook.DTO;


import com.proj.bookbook.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private  Long userIndex;
    private String email;
    private String password;
    private String passwordCheck;
    private String name;

    private String birthY;

    private String birthM;

    private String birthD;

    private LocalDateTime register_date;

    private Long role_id;

    private String userRole;


    UserDTO(User user){
        this.userIndex = user.getUser_id();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.passwordCheck = user.getPasswordCheck();
        this.name = user.getName();
        this.birthY = user.getBirthY();
        this.birthM = user.getBirthM();
        this.birthD = user.getBirthD();
        this.register_date = user.getRegister_date();
        this.role_id =user.getRole().getRole_id();
        this.userRole = user.getUserRole().name();

    }

}