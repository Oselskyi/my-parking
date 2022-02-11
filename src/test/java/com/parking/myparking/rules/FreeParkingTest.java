package com.parking.myparking.rules;

import com.parking.myparking.model.Price;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class FreeParkingTest {


    @Test
    void calculateClientPayment() {
        Ticket ticket = new Ticket();
        LocalDateTime start = LocalDateTime.now().minusMinutes(50);
        ticket.setEnterTime(start);
        FreeParking freeParking = new FreeParking();

        assertEquals(0, freeParking.calculateClientPayment(ticket));
    }
}