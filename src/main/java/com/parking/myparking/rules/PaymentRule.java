package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;

public interface PaymentRule {

    double calculateClientPayment(Ticket ticket, PriceRepository priceRepository);

    boolean shouldRun(Ticket ticket);
}
