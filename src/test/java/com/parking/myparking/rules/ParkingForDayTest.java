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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ParkingForDayTest {

    Ticket ticket;
    ParkingForDay parkingForDay;


    Price hourPrice;

    @Mock
    PriceRepository priceRepository;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket.setEnterTime(LocalDateTime.now().minusHours(14));
        parkingForDay = new ParkingForDay();
        hourPrice = new Price();
    }

    @Test
    void calculateClientPayment() {
        //when(priceRepository.getPrice(anyString())).thenReturn(3);
        double payment = parkingForDay.calculateClientPayment(ticket);
        assertEquals(840, payment);

    }

    @Test
    void shouldRun() {




    }
}