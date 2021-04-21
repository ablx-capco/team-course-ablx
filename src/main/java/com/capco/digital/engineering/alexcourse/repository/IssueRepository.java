package com.capco.digital.engineering.alexcourse.repository;

import com.capco.digital.engineering.alexcourse.model.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends MongoRepository<Issue, String> {}
