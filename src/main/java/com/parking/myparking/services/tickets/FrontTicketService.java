package com.parking.myparking.services.tickets;

import com.parking.myparking.model.Car;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.TicketRepository;

public class FrontTicketService extends AbstractTicketService{
    public FrontTicketService(TicketRepository ticketRepository) {
        super(ticketRepository);
    }

    @Override
    public Ticket createTicket(Car car) {
        return super.createTicket(car);
    }
}
