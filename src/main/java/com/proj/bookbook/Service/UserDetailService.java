package com.proj.bookbook.Service;

import com.proj.bookbook.Model.User;
import com.proj.bookbook.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
//스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    // 사용자 이름(email)으로 사용자의 정보를 가져오는 메서드
    @Override
    public User loadUserByUsername(String email){
        User user = userRepository.findByEmail(email);

        if(user == null  ) {
            throw new UsernameNotFoundException(email);
        }

                return user.builder()
                .user_id(user.getUser_id())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}
