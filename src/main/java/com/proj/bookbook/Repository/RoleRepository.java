package com.proj.bookbook.Repository;

import com.proj.bookbook.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
