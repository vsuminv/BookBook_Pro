//package com.proj.bookbook.config.auth;
//
//import com.proj.bookbook.Model.User;
//import com.proj.bookbook.Repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class PrincipalDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findUserByEmail(email)
//                .orElseThrow(() -> {
//                    return new UsernameNotFoundException("해당 유저를 찾을 수 없습니다.");
//                });
//        return new PrincipalDetails(user);
//    }
//}
