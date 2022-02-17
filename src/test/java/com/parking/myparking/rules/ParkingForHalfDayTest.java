package com.parking.myparking.rules;

import com.parking.myparking.model.Price;
import com.parking.myparking.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ParkingForHalfDayTest {

    Ticket ticket;
    ParkingForHalfDay parkingForHalfDay;
    Price price;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket.setEnterTime(LocalDateTime.now().minusHours(6));

        price = new Price();
        price.setPriceForHalfDay(2);

        parkingForHalfDay = new ParkingForHalfDay();
    }

    @Test
    void calculateClientPayment() {

        assertEquals(12, parkingForHalfDay.calculateClientPayment(ticket, price));
    }

    @Test
    void shouldRun() {
    }
}