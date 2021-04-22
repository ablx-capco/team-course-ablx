package com.capco.digital.engineering.alexcourse.service;

import com.capco.digital.engineering.alexcourse.model.User;
import com.capco.digital.engineering.alexcourse.repository.UserRepository;
import java.util.List;
import java.util.Optional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  Logger logger = LogManager.getLogger(UserServiceImpl.class);
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> retrieveUsers() {
    logger.info("Retrieving all users from mongo db");
    return userRepository.findAll();
  }

  @Override
  public void saveUserDetails(User user) {
   userRepository.save(user);
  }

  @Override
  public Optional<User> retrieveUserById(String userId) {
    return userRepository.findById(userId);
  }
}
