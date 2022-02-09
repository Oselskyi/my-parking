package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParkingMoreThenDayTest {

    Ticket ticket, ticket1;
    ParkingMoreThenDay parkingMoreThenDay;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket1 = new Ticket();
        ticket.setEnterTime(LocalDateTime.now().minusDays(4));
        ticket1.setEnterTime(LocalDateTime.now().minusHours(4));
        parkingMoreThenDay = new ParkingMoreThenDay();
    }

    @Test
    void calculateClientPayment() {
        assertEquals(6000, parkingMoreThenDay.calculateClientPayment(ticket));
    }

    @Test
    void shouldRun() {
        assertTrue(parkingMoreThenDay.shouldRun(ticket));
        assertFalse(parkingMoreThenDay.shouldRun(ticket1));
    }
}