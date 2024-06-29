package com.proj.bookbook.Service;

import com.proj.bookbook.DTO.UserDTO;
import com.proj.bookbook.Model.User;
import com.proj.bookbook.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public void checkUserEmailDuplication(UserDTO userDTO){
        boolean userEmailDuplicate = userRepository.existsByEmail(userDTO.getEmail());
        if (userEmailDuplicate){
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }

    @Transactional(readOnly = true)
    public void checkUserPasswordDuplication(UserDTO userDTO){
        User userPasswordDuplicate = userRepository.findByPassword(userDTO.getPassword());
        User userPasswordCheckDuplicate = userRepository.findByPasswordCheck(userDTO.getPasswordCheck());
        if (userPasswordDuplicate != userPasswordCheckDuplicate){
            throw new IllegalStateException("비밀번호가 일치하지 않음");
        }
    }




}
