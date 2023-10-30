package com.proj.bookbook.Service;

import com.proj.bookbook.DTO.UserDTO;
import com.proj.bookbook.Model.User;
import com.proj.bookbook.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService   {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public void save(UserDTO userDTO)  {
        User user = User.builder()
                .user_id(userDTO.getUserIndex())
                .email(userDTO.getEmail())
                .password(bCryptPasswordEncoder.encode(userDTO.getPassword()))
                .passwordCheck(userDTO.getPasswordCheck())
                .name(userDTO.getName())
                .birth(userDTO.getBirth())
                .register_date(userDTO.getRegister_date())
                .build();

        userRepository.save(user);
    }




}
