package com.parking.myparking.rules;


import com.parking.myparking.model.Ticket;

public class LostTicket implements PaymentRule {



    @Override
    public double calculateClientPayment(Ticket ticket) {

        ticket.setPayment(ticket.getParkingTerminal().getPrice().getPriceForLost());


        return ticket.getPayment();
    }

    @Override
    public boolean shouldRun(Ticket ticket) {
        return ticket.getEnterTime() == null;

    }
}
