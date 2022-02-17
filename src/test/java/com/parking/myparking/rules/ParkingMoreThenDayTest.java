package com.parking.myparking.rules;

import com.parking.myparking.model.Price;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ParkingMoreThenDayTest {

    Ticket ticket;
    ParkingMoreThenDay parkingMoreThenDay;
    Price price;


    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket.setEnterTime(LocalDateTime.now().minusHours(25));

        price = new Price();
        price.setPriceMoreThenDay(20);


        parkingMoreThenDay = new ParkingMoreThenDay();
    }

    @Test
    void calculateClientPayment() {

        assertEquals(20, parkingMoreThenDay.calculateClientPayment(ticket, price));
    }

    @Test
    void shouldRun() {
        assertTrue(parkingMoreThenDay.shouldRun(ticket));
    }
}