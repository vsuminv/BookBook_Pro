package com.proj.bookbook.Repository;

import com.proj.bookbook.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    public  User save( User user);

    boolean existsByEmail(String email);

    public User findByEmail(String email);

    public User findByPassword(String password);
    public User findByPasswordCheck(String passwordCheck);
}
