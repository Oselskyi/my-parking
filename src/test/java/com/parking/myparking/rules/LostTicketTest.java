package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LostTicketTest {

    @Mock
    PriceRepository priceRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateClientPayment() {
        Ticket ticket = new Ticket();
        ticket.setEnterTime(null);
        LostTicket lostTicket = new LostTicket();
        when(priceRepository.getPrice("ForLost")).thenReturn(50);

        assertEquals(50, lostTicket.calculateClientPayment(ticket, priceRepository));
    }

    @Test
    void shouldRun() {
    }
}