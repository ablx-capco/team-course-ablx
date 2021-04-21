package com.capco.digital.engineering.alexcourse.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@WebMvcTest(HelloController.class)
public class HelloControllerTest extends AbstractTestNGSpringContextTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testControllerReturnsCorrectContent() throws Exception {
    this.mockMvc.perform(get("/helloWorld")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello World!")));
  }

}