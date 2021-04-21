package com.capco.digital.engineering.alexcourse.service;

import com.capco.digital.engineering.alexcourse.model.User;
import java.util.List;

public interface UserService {
    List<User> retrieveUsers();

    void saveUserDetails(User user);
}
