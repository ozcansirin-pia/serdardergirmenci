package com.serdardegirmenci.vodafonegarage.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GarageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void parkCarTest() throws Exception {
        mockMvc.perform(post("/park-car")
                .param("car_type", "Jeep")
                .param("car_color", "RED")
                .param("car_plate", "34SDR1982")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Allocated 2 slots.")));
    }

    @Test
    public void parkCarFailTest() throws Exception {
        mockMvc.perform(post("/park-car")
                .param("car_type", "Ship")
                .param("car_color", "RED")
                .param("car_plate", "34SDR1982")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Bad Request")));
    }

    @Test
    public void leaveCarFailTest() throws Exception {
        mockMvc.perform(post("/leave-car")
                .param("ticket", "39")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Bad Request")));
    }

    @Test
    public void getStatusTest() throws Exception {
        mockMvc.perform(get("/status")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
}