package com.chandu.database.controllers;

import com.chandu.database.TestDataUtil;
import com.chandu.database.domain.entities.AuthorEntity;
import com.chandu.database.services.AuthorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTests {
    private MockMvc mockMvc;
    private AuthorService authorService;// as we need to create authors for everytest
    private ObjectMapper objectMapper;
    @Autowired
    public AuthorControllerIntegrationTests(MockMvc mockMvc,ObjectMapper objectMapper, AuthorService authorService) {
        this.mockMvc = mockMvc;
        this.objectMapper=new ObjectMapper();
        this.authorService=authorService;
    }

    @Test
    public void testAuthorCreated201Created() throws Exception {
        AuthorEntity authorA=TestDataUtil.createTestAuthorA(); //create a author
        authorA.setId(null); //setting to new
        String authorJson= objectMapper.writeValueAsString(authorA);
        mockMvc.perform( // send a fake HTTP Post and check if it is created or not just like postman
                MockMvcRequestBuilders.post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }
    @Test
    public void testAuthorReturnsSavedAuthor() throws Exception {
        AuthorEntity authorA=TestDataUtil.createTestAuthorA(); //create a author
        authorA.setId(null); //setting to new
        String authorJson= objectMapper.writeValueAsString(authorA);
        mockMvc.perform( // send a fake HTTP Post and check if it is created or not just like postman
                MockMvcRequestBuilders.post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.name").value("Anushka")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.age").value(80)
        );
    }

    @Test
    public void testAuthorsList200() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }
    @Test
    public void testAuthorsReturnsList() throws Exception {
        AuthorEntity authorEntity=TestDataUtil.createTestAuthorA();
        authorService.createAuthor(authorEntity);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].name").value("Anushka")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].age").value(80)
        );
    }

    @Test
    public void testAuthorFound200(){

    }
}
