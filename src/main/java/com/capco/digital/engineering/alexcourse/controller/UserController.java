package com.capco.digital.engineering.alexcourse.controller;

import com.capco.digital.engineering.alexcourse.model.User;
import com.capco.digital.engineering.alexcourse.service.UserService;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public List<User> getUsers(){
    return userService.retrieveUsers();
  }

  @PostMapping("/users")
  public ResponseEntity<?> saveUser(@RequestBody @Valid User user){
    userService.saveUserDetails(user);
    return ResponseEntity.created(URI.create("/users")).build();
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<User> retrieveUserById(@PathVariable String id){
    Optional<User> users = userService.retrieveUserById(id);
    return users.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

}
