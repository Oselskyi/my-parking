package com.parking.myparking.rules;

import com.parking.myparking.model.Price;
import com.parking.myparking.model.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingForDay implements PaymentRule {


    @Override
    public double calculateClientPayment(Ticket ticket, Price price) {

        ticket.setPayment(ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.HOURS)
                * price.getPriceForDay());
        return ticket.getPayment();
    }


    @Override
    public boolean shouldRun(Ticket ticket) {

        return ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.MINUTES) > 60*12
                && ticket.getEnterTime().until(LocalDateTime.now(), ChronoUnit.MINUTES) <= 60*24;
    }
}
