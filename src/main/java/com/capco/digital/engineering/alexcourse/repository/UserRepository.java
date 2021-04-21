package com.capco.digital.engineering.alexcourse.repository;

import com.capco.digital.engineering.alexcourse.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
