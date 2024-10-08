package com.Aashish.online_platform.project.service;

import java.util.List;

import com.Aashish.online_platform.project.dto.UserDto;
import com.Aashish.online_platform.project.entity.User;


public interface UserService {
    void saveUser(UserDto userDto);  
    User findUserByEmail(String email);
    User findUserById(Long id); // Add this method
    List<UserDto> findAllUsers();  
    void updateUser(Long userId, UserDto userDto);
    void deleteUser(Long id);
}
