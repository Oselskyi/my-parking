package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParkingForDayTest {

    Ticket ticket;
    ParkingForDay parkingForDay;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket.setEnterTime(LocalDateTime.now().minusHours(14));
        parkingForDay = new ParkingForDay();
    }

    @Test
    void calculateClientPayment() {
        assertEquals(840, parkingForDay.calculateClientPayment(ticket));

    }

    @Test
    void shouldRun() {




    }
}