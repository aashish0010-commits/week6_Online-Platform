package com.Aashish.online_platform.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Aashish.online_platform.project.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}