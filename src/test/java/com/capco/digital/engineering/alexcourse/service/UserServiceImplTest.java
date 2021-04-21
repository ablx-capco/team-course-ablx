package com.capco.digital.engineering.alexcourse.service;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;

import com.capco.digital.engineering.alexcourse.model.User;
import com.capco.digital.engineering.alexcourse.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.junit.MockitoTestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(MockitoTestNGListener.class)
public class UserServiceImplTest {

  @InjectMocks
  UserServiceImpl userService;

  @Mock
  private UserRepository userRepository;

  @BeforeClass
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testRetrieveUsers() {
    given(userRepository.findAll())
        .willReturn(List.of(new User("John", "Smith"), new User("Bob", "Smith")));
    List<User> users = userService.retrieveUsers();
    assertEquals(users,List.of(new User("John", "Smith"), new User("Bob", "Smith")));
  }

  @Test
  public void testSaveUserDetails() {
    User userToSave = new User("John", "Smith");
    userService.saveUserDetails(userToSave);
    verify(userRepository, times(1)).save(userToSave);
  }

  @Test
  public void testRetrieveUserById() {
    given(userRepository.findById("1"))
        .willReturn(Optional.of(new User("John", "Smith")));
    Optional<User> user = userService.retrieveUserById("1");
    assertTrue(user.isPresent());
    assertEquals(user.get(),new User("John", "Smith"));
  }
}