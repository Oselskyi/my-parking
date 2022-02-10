package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingMoreThenDay implements PaymentRule {


    @Override
    public double calculateClientPayment(Ticket ticket, PriceRepository priceRepository) {

        ticket.setPayment(ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.DAYS) * priceRepository.getPrice("ForMoreThanDay"));
        return ticket.getPayment();
    }


    @Override
    public boolean shouldRun(Ticket ticket) {

        return ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.MINUTES) > 60*24;
    }
}
