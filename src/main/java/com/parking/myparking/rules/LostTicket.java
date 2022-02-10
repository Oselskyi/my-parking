package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;

public class LostTicket implements PaymentRule {
    @Override
    public double calculateClientPayment(Ticket ticket, PriceRepository priceRepository) {

        ticket.setPayment(priceRepository.getPrice("ForLost"));


        return ticket.getPayment();
    }

    @Override
    public boolean shouldRun(Ticket ticket) {
        return ticket.getEnterTime() == null;

    }
}
