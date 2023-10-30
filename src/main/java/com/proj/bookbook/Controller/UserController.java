package com.proj.bookbook.Controller;


import com.proj.bookbook.DTO.ResponseDTO;
import com.proj.bookbook.DTO.UserDTO;
import com.proj.bookbook.Model.User;
import com.proj.bookbook.Service.UserDetailService;
import com.proj.bookbook.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth" )
@CrossOrigin("*")
public class UserController {


    private final UserService userService;
    private final UserDetailService detailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;





    @PostMapping("/join")
    public ResponseEntity save (@RequestBody UserDTO userDTO){

        userService.save(userDTO);
        return  ResponseEntity.ok().body(userDTO);
    }




    @PostMapping("/login")
    public ResponseEntity loadUserByUsername (@RequestBody UserDTO userDTO, String email){




        User user = detailService.loadUserByUsername(
                userDTO.getEmail());

        if (!bCryptPasswordEncoder.matches(userDTO.getPassword(), user.getPassword() )) {
            throw new BadCredentialsException("잘못된 계정정보입니다.");

        } else{
            userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
            ResponseDTO responseDTO = ResponseDTO.builder().result(1).build();
            return ResponseEntity.ok().body(responseDTO);
        }



    }

    @PostMapping("/admin")
    public String admin (){
        return "admin";
    }
}
