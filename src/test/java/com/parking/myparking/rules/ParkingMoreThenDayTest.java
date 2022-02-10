package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ParkingMoreThenDayTest {

    Ticket ticket, ticket1;
    ParkingMoreThenDay parkingMoreThenDay;

    @Mock
    PriceRepository priceRepository;

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
        when(priceRepository.getPrice(any())).thenReturn(20);

        assertEquals(20, parkingMoreThenDay.calculateClientPayment(ticket, priceRepository));
    }

    @Test
    void shouldRun() {
        assertTrue(parkingMoreThenDay.shouldRun(ticket));
        assertFalse(parkingMoreThenDay.shouldRun(ticket1));
    }
}