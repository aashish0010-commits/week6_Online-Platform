package com.Aashish.online_platform.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Aashish.online_platform.project.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
