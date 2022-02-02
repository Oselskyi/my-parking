package com.parking.myparking.services.tickets;

import com.parking.myparking.model.Car;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.TicketRepository;

import java.time.LocalDateTime;

public abstract class AbstractTicketService implements TicketService{

    private final TicketRepository ticketRepository;

    protected AbstractTicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(Car car) {
        LocalDateTime localDateTime = LocalDateTime.now().withNano(0);
        Ticket ticket = new Ticket(localDateTime);
        ticketRepository.save(ticket);
        return ticket;
    }
}
