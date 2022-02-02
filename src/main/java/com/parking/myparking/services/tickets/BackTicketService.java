package com.parking.myparking.services.tickets;

import com.parking.myparking.model.Car;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.TicketRepository;


public class BackTicketService extends AbstractTicketService{


    protected BackTicketService(TicketRepository ticketRepository) {
        super(ticketRepository);
    }

    @Override
    public Ticket createTicket(Car car) {
        return super.createTicket(car);
    }
}
