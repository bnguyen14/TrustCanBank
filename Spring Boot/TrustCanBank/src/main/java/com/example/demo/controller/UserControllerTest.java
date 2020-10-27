package com.example.demo.controller;
import com.example.demo.entity.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

public class UserControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp(){
        super.setUp();
    }

    @Test
    public void findUser() throws Exception{
        String uri = "http://localhost:8080/api/users/1";
        User theUser = new User();
        theUser.setUsername("gaurav");
        String inputJson = super.mapToJson(theUser);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .content(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, theUser.getUsername(),"username test");
    }
}
