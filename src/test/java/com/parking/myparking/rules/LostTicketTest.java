package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LostTicketTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateClientPayment() {
        Ticket ticket = new Ticket();
        ticket.setEnterTime(null);
        LostTicket lostTicket = new LostTicket();

        assertEquals(10000, lostTicket.calculateClientPayment(ticket));
    }

    @Test
    void shouldRun() {
    }
}