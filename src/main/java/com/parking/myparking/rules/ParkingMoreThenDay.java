package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingMoreThenDay implements PaymentRule {


    @Override
    public double calculateClientPayment(Ticket ticket) {

        ticket.setPayment(ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.MINUTES) / 1440 * 1500);
        return ticket.getPayment();
    }


    @Override
    public boolean shouldRun(Ticket ticket) {

        return ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.MINUTES) > 1440;
    }
}
