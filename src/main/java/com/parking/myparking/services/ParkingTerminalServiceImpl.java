package com.parking.myparking.services;

import com.parking.myparking.model.Price;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.TicketRepository;
import com.parking.myparking.rules.*;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ParkingTerminalServiceImpl implements ParkingTerminalService {

    private final TicketRepository ticketRepository;
    private final ParkingServiceImpl parkingService;
    Price price = new Price();


    private List<PaymentRule> rules;

    public ParkingTerminalServiceImpl(TicketRepository ticketRepository, ParkingServiceImpl parkingService) {
        this.ticketRepository = ticketRepository;
        this.parkingService = parkingService;

        rules = List.of(
                new FreeParking(), new ParkingForHalfDay(),
                new ParkingForDay(), new ParkingMoreThenDay(),
                new LostTicket());

    }

    @Override
    public List<Ticket> showAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket enter() {
        Ticket newTicket = Ticket.forEntry(parkingService.getTerminalByName("back"));
        ticketRepository.save(newTicket);

        return newTicket;
    }

    @Override
    public Double exit(Long id) {

        Ticket ticket = ticketRepository.getById(id);

        rules.stream()
                .filter(rule -> rule.shouldRun(ticket))
                .forEach(rule -> rule.calculateClientPayment(ticket));
        ticketRepository.deleteById(id);

        return ticket.getPayment();
    }


}
