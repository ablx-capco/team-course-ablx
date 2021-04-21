package com.capco.digital.engineering.alexcourse.controller;

import com.capco.digital.engineering.alexcourse.model.Issue;
import com.capco.digital.engineering.alexcourse.repository.IssueRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueController {

  private IssueRepository repository;

  public IssueController(IssueRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/issues")
  public List<Issue> getAllIssues() {
    return repository.findAll();
  }
}
