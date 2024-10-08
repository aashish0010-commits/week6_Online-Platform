package com.Aashish.online_platform.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


import com.Aashish.online_platform.project.dto.UserDto;
import com.Aashish.online_platform.project.entity.User;
import com.Aashish.online_platform.project.service.UserService;

public class UserControllerIntegrationTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(1L);
        user.setName("Aashish");
        user.setEmail("nepal.aashish00@gmail.com");
    }

    @Test
    public void testEditUser_UserNotFound() {
        when(userService.findUserById(1L)).thenReturn(null);

        String viewName = userController.editUser(1L, model);

        verify(model).addAttribute("errorMessage", "User not found");
        assertEquals("error", viewName);
    }

    @Test
    public void testUpdateUser_Success() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("Aashish");
        userDto.setLastName("Nepal");
        userDto.setEmail("nepal.aashish00@gmail.com");

        doNothing().when(userService).updateUser(1L, userDto);
        
        String viewName = userController.updateUser(1L, userDto, model);

        verify(model).addAttribute("successMessage", "User updated successfully!");
        assertEquals("redirects:/users", viewName);
    }

    @Test
    public void testUpdateUser_Failure() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("Aashish");
        userDto.setLastName("Nepal");
        userDto.setEmail("nepal.asshish00@gmail.com");

        doThrow(new RuntimeException("Update failed")).when(userService).updateUser(1L, userDto);
        
        String viewName = userController.updateUser(1L, userDto, model);

        verify(model).addAttribute("errorMessage", "Failed to update user: Update failed");
        assertEquals("users/userUpdate", viewName);
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userService).deleteUser(1L);
        String viewName = userController.deleteUser(1L);
        verify(userService).deleteUser(1L);
        assertEquals("redirect:/users", viewName);
    }
}
