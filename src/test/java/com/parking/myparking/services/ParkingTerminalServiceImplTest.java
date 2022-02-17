package com.parking.myparking.services;

import com.parking.myparking.model.ParkingTerminal;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.ParkingTerminalRepository;
import com.parking.myparking.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ParkingTerminalServiceImplTest {

    @InjectMocks
    ParkingTerminalServiceImpl parkingTerminalService;

    @Mock
    ParkingService parkingService;
    @Mock
    TicketRepository ticketRepository;

    Ticket ticket1;
    Ticket ticket2;


    @BeforeEach
    void setUp() {

        ticket1 = new Ticket(1L, 12, LocalDateTime.now(), 0, new ParkingTerminal());
        ticket2 = new Ticket(2L, 22, LocalDateTime.now(), 0, new ParkingTerminal());
    }

    @Test
    void showAllVisitors() {
        List<Ticket> returnTickets = List.of(ticket1, ticket2);

        when(ticketRepository.findAll()).thenReturn(returnTickets);

        List<Ticket> tickets = parkingTerminalService.showAllTickets();

        assertNotNull(tickets);
        assertEquals(2, tickets.size());
    }

    @Test
    void enter() {

//        when(parkingService.getTerminalByName("back")).thenReturn(parkingTerminal);
        when(ticketRepository.save(any())).thenReturn(ticket1);

        Ticket savedTicket = parkingTerminalService.enter();
        assertNotNull(savedTicket);
    }

    @Test
    void exit() {
        when(ticketRepository.getById(anyLong())).thenReturn(ticket2);
        parkingTerminalService.exit(1L);

        verify(ticketRepository).deleteById(anyLong());
    }
}