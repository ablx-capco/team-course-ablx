package com.capco.digital.engineering.alexcourse.controller;

import com.capco.digital.engineering.alexcourse.model.Message;
import com.capco.digital.engineering.alexcourse.service.UserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  Logger log = LogManager.getLogger(HelloController.class);
  @GetMapping("/helloWorld")
  public ResponseEntity<Message> hello(){
    Message message = new Message("Hello World!");

    return ResponseEntity.ok(message);
  }

  @GetMapping("/lombok")
  public String index() {
    log.trace("A TRACE Message");
    log.debug("A DEBUG Message");
    log.info("An INFO Message");
    log.warn("A WARN Message");
    log.error("An ERROR Message");

    return "Howdy! Check out the Logs to see the output...";
  }

}
