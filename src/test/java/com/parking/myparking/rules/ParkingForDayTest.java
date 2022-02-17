package com.parking.myparking.rules;

import com.parking.myparking.model.Price;
import com.parking.myparking.model.Ticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class ParkingForDayTest {

    Ticket ticket;
    ParkingForDay parkingForDay;
    Price price;


    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket.setEnterTime(LocalDateTime.now().minusHours(12));

        price = new Price();
        price.setPriceForDay(3);

        parkingForDay = new ParkingForDay();

    }

    @Test
    void calculateClientPayment() {

        double payment = parkingForDay.calculateClientPayment(ticket, price);
        assertEquals(36, payment);

    }

    @Test
    void shouldRun() {

    }
}