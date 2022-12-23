package com.example.demo;

import controllers.DemoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DemoController.class)
@AutoConfigureMockMvc
class DemoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldGreetUserWithHisName() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello?myName=Nikolay").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello Nikolay!")));
    }

}
