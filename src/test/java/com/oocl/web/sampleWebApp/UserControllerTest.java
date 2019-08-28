package com.oocl.web.sampleWebApp;
import static org.hamcrest.Matchers.containsString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import net.minidev.json.JSONObject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
    public void should_return_201_when_post() throws Exception {
        
        
        
        Map<String, String> map = new HashMap<>();
        map.put("name", "lisa");
        String content = JSONObject.toJSONString(map);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andDo(print())
                .andExpect(status().isCreated());

       

    }
    
    @Test
    public void should_return_200_when_get() throws Exception {
        mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("s")));

    }
}
