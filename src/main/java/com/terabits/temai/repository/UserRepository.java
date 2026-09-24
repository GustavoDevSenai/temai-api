package com.terabits.temai.repository;

import com.terabits.temai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByPhone(String phone);

    boolean existsByPhone(String phone);
}
