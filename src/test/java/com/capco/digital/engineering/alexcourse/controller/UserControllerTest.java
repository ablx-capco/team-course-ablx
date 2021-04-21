package com.capco.digital.engineering.alexcourse.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.capco.digital.engineering.alexcourse.model.User;
import com.capco.digital.engineering.alexcourse.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;

@WebMvcTest(UserController.class)
public class UserControllerTest extends AbstractTestNGSpringContextTests {

  private @MockBean
  @Autowired
  UserServiceImpl userService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  WebApplicationContext webApplicationContext;

  @Test
  public void testRetrieveUserController() throws Exception {
    given(userService.retrieveUsers())
        .willReturn(List.of(new User("John", "Smith"), new User("Bob", "Smith")));

    this.mockMvc.perform(get("/users"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(content()
            .string(containsString("{\"id\":null,\"firstName\":\"John\","
                + "\"lastName\":\"Smith\"},{\"id\":null,\"firstName\":\"Bob\",\"lastName\":\"Smith\"}"
            )));
  }

  @Test
  public void testSaveUserController() throws Exception {
    User userToSave = new User("John", "Smith");
    String jsonBody = objectMapper.writeValueAsString(userToSave);
    System.out.println(jsonBody);
    this.mockMvc.perform(post("/users")
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());

    verify(userService, times(1)).saveUserDetails(userToSave);
  }


}