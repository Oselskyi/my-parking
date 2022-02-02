package com.parking.myparking.services.tickets;

import com.parking.myparking.model.Car;
import com.parking.myparking.model.Ticket;

public interface TicketService {
    Ticket createTicket(Car car);
}
