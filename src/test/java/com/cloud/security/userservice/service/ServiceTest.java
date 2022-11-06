package com.cloud.security.userservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cloud.security.userservice.entity.User;
import com.cloud.security.userservice.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;

  private User user;

  List<User>list = new ArrayList<>();

  @BeforeEach
  void setup() {

    user = new User();
    user.setId(1);
    user.setName("Yimy");
    user.setEmail("zepedayimy46@gmail.com");
    list.add(user);
  }

  @Test
  public void findByIdTest() {
    when(userRepository.findById(1)).thenReturn(Optional.of(user));
    userService.getUserById(1);
    verify(userRepository, times(1)).findById(1);
    assertEquals(userService.getUserById(1), user);
  }

  @Test
  public void saveTest(){
    when(userRepository.save(any())).thenReturn(user);
    userService.save(user);
    verify(userRepository).save(user);
    assertEquals(userService.save(user),user);
  }

  @Test
  public void listUserTest(){
    when(userRepository.findAll()).thenReturn(list);
    userService.getListAll();
    verify(userRepository,times(1)).findAll();
    assertEquals(userService.getListAll(),list);
    assertEquals(userService.getListAll().size(),1);
    assertNotNull(userService.getListAll());


  }
}
