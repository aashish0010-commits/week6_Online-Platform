package com.Aashish.online_platform.project.service;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.Aashish.online_platform.project.entity.User;
import com.Aashish.online_platform.project.repository.UserRepository;


public class MainUserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private MainUserService userMainService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));
        userMainService.deleteUser(userId);
        verify(userRepository).deleteById(userId);
    }
}
