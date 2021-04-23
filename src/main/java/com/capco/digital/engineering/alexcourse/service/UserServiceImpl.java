package com.capco.digital.engineering.alexcourse.service;

import com.capco.digital.engineering.alexcourse.model.User;
import com.capco.digital.engineering.alexcourse.repository.UserRepository;
import java.util.List;
import java.util.Optional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  Logger logger = LogManager.getLogger(UserServiceImpl.class);
  private final UserRepository userRepository;
  private final KafkaTemplate<String, String> kafkaTemplate;

  private final static String NEW_USER_TOPIC = "test";

  private void sendMessage(String msg) {
    kafkaTemplate.send(NEW_USER_TOPIC,"USER", msg);
  }

  public UserServiceImpl(
      UserRepository userRepository,
      KafkaTemplate<String, String> kafkaTemplate) {
    this.userRepository = userRepository;
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public List<User> retrieveUsers() {
    logger.info("Retrieving all users from mongo db");
    return userRepository.findAll();
  }

  @Override
  public void saveUserDetails(User user) {
    sendMessage("New User Alert!");
   userRepository.save(user);
  }

  @Override
  public Optional<User> retrieveUserById(String userId) {
    return userRepository.findById(userId);
  }
}
