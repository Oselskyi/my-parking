package com.parking.myparking.services;

import com.parking.myparking.model.Car;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WestTicketService implements TicketService{

    private final TicketRepository ticketRepository;

    public WestTicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(Car car) {

            LocalDateTime localDateTime = LocalDateTime.now();
            Ticket ticket = new Ticket(localDateTime, car);
            ticketRepository.save(ticket);
            return ticket;

    }
}
