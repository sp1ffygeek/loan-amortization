package com.user;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by sp1ffygeek on 10/7/16.
 */
@Ignore
public class UserControllerTest extends UserApplicationTests {

    private static final String ID = "sp1ffygeek";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void validate_get_validuser() throws Exception {
        mockMvc.perform(get("/api/finduser?userId={id}", ID))
                .andExpect(status().isOk());
    }

    @Test
    public void validate_get_invaliduser() throws Exception {
        mockMvc.perform(get("/api/finduser?userId={id}", "abc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.errorCode").value("412"));
    }

    @Test
    public void validate_post_validuser() throws Exception {
        mockMvc.perform(post("/api/validateuser").contentType(MediaType.APPLICATION_JSON).content("{\"userId\":\"spxffygeek\"}"))
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void validate_post_invaliduser() throws Exception {
        mockMvc.perform(post("/api/validateuser").contentType(MediaType.APPLICATION_JSON).content("{\"userId\":\"spxffygeek\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.errorCode").value("412"));
    }
}
