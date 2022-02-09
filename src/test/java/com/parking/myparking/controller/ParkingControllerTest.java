package com.parking.myparking.controller;

import com.parking.myparking.model.ParkingTerminal;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.services.ParkingTerminalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ParkingControllerTest {

    @Mock
    ParkingTerminalService parkingTerminalService;

    @InjectMocks
    ParkingController parkingController;

    List<Ticket> tickets;
    Ticket ticket;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        tickets = new ArrayList<>();
        ticket = new Ticket(1L, 12, LocalDateTime.now(), 0, new ParkingTerminal());
        tickets.add(ticket);
        tickets.add(new Ticket(2L, 22, LocalDateTime.now(), 0, new ParkingTerminal()));

        mockMvc = MockMvcBuilders.standaloneSetup(parkingController).build();
    }

    @Test
    void showAllTickets() throws Exception {
        when(parkingTerminalService.showAllTickets()).thenReturn(tickets);
        mockMvc.perform(get("/tickets"))
                .andExpect(status().isOk());
    }

    @Test
    void enter() throws Exception {
        when(parkingTerminalService.enter()).thenReturn(ticket);

        mockMvc.perform(post("/tickets"))
                .andExpect(status().isOk());
    }

    @Test
    void exit() throws Exception {
        when(parkingTerminalService.exit(anyLong())).thenReturn(20.2);

        mockMvc.perform(delete("/tickets/1"))
                .andExpect(status().isOk());
    }
}