package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingForDay implements PaymentRule {


    public ParkingForDay() {
    }


    @Override
    public double calculateClientPayment(Ticket ticket) {

        ticket.setPayment(ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.HOURS)
                * ticket.getParkingTerminal().getPrice().getPriceForDay());
        return ticket.getPayment();
    }


    @Override
    public boolean shouldRun(Ticket ticket) {

        return ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.MINUTES) > 60*12
                && ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.MINUTES) <= 60*24;
    }
}
