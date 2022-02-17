package com.parking.myparking.rules;


import com.parking.myparking.model.Price;
import com.parking.myparking.model.Ticket;

public class LostTicket implements PaymentRule {



    @Override
    public double calculateClientPayment(Ticket ticket, Price price) {

        ticket.setPayment(price.getPriceForLost());


        return ticket.getPayment();
    }

    @Override
    public boolean shouldRun(Ticket ticket) {
        return ticket.getEnterTime() == null;

    }
}
