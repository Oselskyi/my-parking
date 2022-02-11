package com.parking.myparking.rules;

import com.parking.myparking.model.Price;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LostTicketTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateClientPayment() {
        Ticket ticket = new Ticket();
        ticket.setEnterTime(null);
        LostTicket lostTicket = new LostTicket();
        //when(priceRepository.getPrice("ForLost")).thenReturn(50);

        assertEquals(50, lostTicket.calculateClientPayment(ticket));
    }

    @Test
    void shouldRun() {
    }
}