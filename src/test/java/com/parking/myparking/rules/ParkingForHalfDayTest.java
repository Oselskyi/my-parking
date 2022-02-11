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
import static org.mockito.Mockito.when;

class ParkingForHalfDayTest {

    Ticket ticket;
    ParkingForHalfDay parkingForHalfDay;

    Price hourPrice;

    @Mock
    PriceRepository priceRepository;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket.setEnterTime(LocalDateTime.now().minusHours(6));
        parkingForHalfDay = new ParkingForHalfDay();
    }

    @Test
    void calculateClientPayment() {
        //when(priceRepository.getPrice("ForHalfDay")).thenReturn(2);
        assertEquals(12, parkingForHalfDay.calculateClientPayment(ticket));
    }

    @Test
    void shouldRun() {
    }
}