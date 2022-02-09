package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParkingForHalfDayTest {

    Ticket ticket;
    ParkingForHalfDay parkingForHalfDay;
    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket.setEnterTime(LocalDateTime.now().minusHours(6));
        parkingForHalfDay = new ParkingForHalfDay();
    }

    @Test
    void calculateClientPayment() {
        assertEquals(300, parkingForHalfDay.calculateClientPayment(ticket));
    }

    @Test
    void shouldRun() {
    }
}