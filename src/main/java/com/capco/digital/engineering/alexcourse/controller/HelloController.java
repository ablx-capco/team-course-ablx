package com.capco.digital.engineering.alexcourse.controller;

import com.capco.digital.engineering.alexcourse.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/helloWorld")
  public ResponseEntity<Message> hello(){
    Message message = new Message("Hello World!");

    return ResponseEntity.ok(message);
  }

}
