package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;

import java.time.LocalDateTime;

import java.time.temporal.ChronoUnit;


public class FreeParking implements PaymentRule {

    @Override
    public double calculateClientPayment(Ticket ticket, PriceRepository priceRepository) {

        ticket.setPayment(0);
        return ticket.getPayment();
    }

    @Override
    public boolean shouldRun(Ticket ticket) {

        return ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.MINUTES) <= 60;
    }
}
