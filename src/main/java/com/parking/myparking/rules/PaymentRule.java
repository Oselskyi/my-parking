package com.parking.myparking.rules;

import com.parking.myparking.model.Ticket;

public interface PaymentRule {

    double calculateClientPayment(Ticket ticket);

    boolean shouldRun(Ticket ticket);
}
