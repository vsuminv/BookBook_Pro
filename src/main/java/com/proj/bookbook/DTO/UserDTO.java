package com.proj.bookbook.DTO;


import com.proj.bookbook.Model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    @Pattern(regexp = "/^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$/;" )
    private String email;

    @NotBlank(message =  "비밀번호를 입력해주세요.")
    @Pattern(regexp = "/^(?=.*[a-z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/", message = "비밀번호는 8자 이상 12자 이하로 입력해주세요.")
    private String password;

    @NotBlank(message =  "비밀번호를 입력해주세요.")
    @Pattern(regexp = "/^(?=.*[a-z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/", message = "비밀번호는 8자 이상 12자 이하로 입력해주세요.")
    private String passwordCheck;

    @NotBlank(message = "이름을 입력해주세요.")
    @Pattern(regexp = "/^[가-힣]+.{2,15}$/", message = "이름은 3자이상 15자 이하로 입력해주세요.")
    private String name;

    @NotBlank(message = "생년월일을 입력해주세요.")
    private String birth;

    private LocalDateTime register_date;

    private Long role_id;

    private String userRole;


    UserDTO(User user){
        this.userIndex = user.getUser_id();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.passwordCheck = user.getPasswordCheck();
        this.name = user.getName();
        this.birth = user.getBirth();
        this.register_date = user.getRegister_date();
        this.role_id =user.getRole().getRole_id();

    }

}