package com.serdardegirmenci.vodafone.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ProduceCarTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void produceCarTest() throws Exception {
        mockMvc.perform(post("/produce-car")
                .param("car_type", "Cabrio")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cabrio Car has produced.")));
    }

    @Test
    public void produceCarFailTest() throws Exception {
        mockMvc.perform(post("/produce-car")
                .param("car_type", "Ship")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Car could not be produce")));
    }
}