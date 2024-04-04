package org.example.storage.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.storage.entities.Supply;
import org.example.storage.servises.SupplyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@WebMvcTest(SupplyController.class)
public class SupplyControllerTest {
    @MockBean
    private SupplyService supplyService;
    @InjectMocks
    private SupplyController supplyController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getSupplyByIdTest()throws Exception{
        Supply supply = new Supply(2L,"snikers","Alex");
        when(supplyService.getSupplyById(2L)).thenReturn(supply);
        mockMvc.perform(get("/supplies/{id}",2L))
        .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.name").value("snikers"))
                .andExpect(jsonPath("$.username").value("Alex"));
        verify(supplyService,times(1)).getSupplyById(any());
    }
    @Test
    void getCountFreeSupply()throws Exception{
        Supply supply = new Supply(2L,"snikers","Alex");
        when(supplyService.getCountFreeSupply("snikers")).thenReturn(1);
        mockMvc.perform(get("/supplies/{name}/count","snikers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(1));
        verify(supplyService,times(1)).getCountFreeSupply("snikers");
    }
    @Test
    void getFirstFreeSupplyByName()throws Exception{
        Supply supply = new Supply(2L,"snikers","Alex");
        when(supplyService.getFirstFreeSupplyByName("snikers")).thenReturn(supply);
        mockMvc.perform(get("/supplies/{name}/first_free","snikers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.name").value("snikers"))
                .andExpect(jsonPath("$.username").value("Alex"));
        verify(supplyService,times(1)).getFirstFreeSupplyByName("snikers");

    }
    @Test
    void createSupply()throws Exception{
        Supply supply = new Supply(2L,"snikers","Alex");
        when(supplyService.createSupply(supply)).thenReturn(supply);
        String supplyJson = objectMapper.writeValueAsString(supply);
        mockMvc.perform(post("/supplies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(supplyJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.name").value("snikers"))
                .andExpect(jsonPath("$.username").value("Alex"));;
        verify(supplyService,times(1)).createSupply(supply);
    }
    @Test
    void updateSupply()throws Exception{
        Supply supply = new Supply(2L,"snikers","Alex");
        when(supplyService.updateSupply(supply)).thenReturn(supply);
        String supplyJson = objectMapper.writeValueAsString(supply);
        mockMvc.perform(put("/supplies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(supplyJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.name").value("snikers"))
                .andExpect(jsonPath("$.username").value("Alex"));;
        verify(supplyService,times(1)).updateSupply(supply);


    }

    @Test
    void deleteSupplyById() throws Exception {
        Supply supply = new Supply(2L,"snikers","Alex");
        mockMvc.perform(delete("/supplies/{id}",2L))
                .andExpect(status().isNoContent());
        verify(supplyService,times(1)).deleteSupplyById(2L);

    }

}
