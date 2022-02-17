package com.parking.myparking.rules;

import com.parking.myparking.model.Price;
import com.parking.myparking.model.Ticket;

public interface PaymentRule {

    double calculateClientPayment(Ticket ticket, Price price);

    boolean shouldRun(Ticket ticket);
}
