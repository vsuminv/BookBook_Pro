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
                .birthY(userDTO.getBirthY())
                .birthM(userDTO.getBirthM())
                .birthD(userDTO.getBirthD())
                .register_date(userDTO.getRegister_date())
                .build();

        userRepository.save(user);
    }

    /**
     * 로그인 기능
     * 화면에서 LoginRequest(loginId, password)을 입력받아 loginId와 password가 일치하면 User return
     * loginId가 존재하지 않거나 password가 일치하지 않으면 null return
     *
     * @return
     */
//    public User login( UserDTO userDTO) {
//        Optional<User> optionalUser = userRepository.findUserByEmail(userDTO.getEmail());
//
//        // loginId와 일치하는 User가 없으면 null return
//        if(optionalUser.isEmpty()) {
//            return null;
//        }
//
//        User user = optionalUser.get();
//
//        // 찾아온 User의 password와 입력된 password가 다르면 null return
//        if(!user.getPassword().equals(userDTO.getPassword())) {
//            return null;
//        }
//
//        return user;
//    }
//
//    /**
//     * userId(Long)를 입력받아 User을 return 해주는 기능
//     * 인증, 인가 시 사용
//     * userId가 null이거나(로그인 X) userId로 찾아온 User가 없으면 null return
//     * userId로 찾아온 User가 존재하면 User return
//     */
//    public User getLoginUserById(Long userId) {
//        if(userId == null) return null;
//
//        Optional<User> optionalUser = userRepository.findById(userId);
//        if(optionalUser.isEmpty()) return null;
//
//        return optionalUser.get();
//    }
//
//    /**
//     * loginId(String)를 입력받아 User을 return 해주는 기능
//     * 인증, 인가 시 사용
//     * loginId가 null이거나(로그인 X) userId로 찾아온 User가 없으면 null return
//     * loginId로 찾아온 User가 존재하면 User return
//     */
//    public User getLoginUserByLoginId(String loginId) {
//        if(loginId == null) return null;
//
//        Optional<User> optionalUser = userRepository.findUserByEmail(loginId);
//        if(optionalUser.isEmpty()) return null;
//
//        return optionalUser.get();
//    }
//

//    public User create(UserDTO userDTO){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        User user = User.builder()
//                .email(userDTO.getEmail())
//                .password(passwordEncoder.encode(userDTO.getPassword()))
//                .build();
//        if(userDTO == null || userDTO.getEmail()==null){
//            throw new RuntimeException("가입된 회원이 아닙니다.");
//        }
//        final String email = userDTO.getEmail();
//        if(userRepository.existsByEmail(email)){
////            log.warn("이미 가입된 회원입니다.",userEmail);
//            throw new RuntimeException("이미 가입된 회원입니다.");
//        }
//
//        return userRepository.findUserByEmail(email);
//    }



}
