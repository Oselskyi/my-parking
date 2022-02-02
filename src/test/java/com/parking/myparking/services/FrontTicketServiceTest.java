package com.parking.myparking.services;

import com.parking.myparking.model.Car;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.TicketRepository;
import com.parking.myparking.services.tickets.FrontTicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FrontTicketServiceTest {

    FrontTicketService ticketService;

    @Mock
    TicketRepository ticketRepository;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ticketService = new FrontTicketService(ticketRepository);
    }

    @Test
    void createTicket() {
        Ticket ticket = new Ticket(LocalDateTime.now().withNano(0));

        Car car = new Car();
        Ticket newTicket = ticketService.createTicket(car);
        assertEquals(ticket, newTicket);
    }
}