package com.capco.digital.engineering.alexcourse.service;

import com.capco.digital.engineering.alexcourse.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> retrieveUsers();

    void saveUserDetails(User user);

    Optional<User> retrieveUserById(String userId);
}
