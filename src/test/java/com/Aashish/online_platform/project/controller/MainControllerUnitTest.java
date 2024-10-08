package com.Aashish.online_platform.project.controller;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


import com.Aashish.online_platform.project.service.UserService;

public class MainControllerUnitTest {

    @InjectMocks
    private MainController mainController;

    @Mock
    private UserService userService;

    @Mock
    private Model model;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListUsers() {
        when(userService.findAllUsers()).thenReturn(new ArrayList<>());
        String viewName = mainController.listUsers(model);
        verify(userService).findAllUsers();
        assertEquals("users/userRecords", viewName);
    }

    @Test
public void testHandleUserDeletion() {
    // Arrange
    Long userId = 1L;

    // Act
    String viewName = mainController.deleteUser(userId);

    // Assert
    verify(userService).deleteUser(userId); 
    assertEquals("redirect:/users", viewName);
}
}
