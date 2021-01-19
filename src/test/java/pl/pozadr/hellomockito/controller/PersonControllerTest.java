package pl.pozadr.hellomockito.controller;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getPeopleLimited() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/people/{limit}", 2))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].name", Is.is("Andrzej")))
                .andExpect(jsonPath("$[1].surname", Is.is("Cyrkowiec")));
    }

    @Test
    void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/people/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from people API!"));
    }
}