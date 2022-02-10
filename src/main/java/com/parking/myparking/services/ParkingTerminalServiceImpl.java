package com.parking.myparking.services;

import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;
import com.parking.myparking.repository.TicketRepository;
import com.parking.myparking.rules.*;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ParkingTerminalServiceImpl implements ParkingTerminalService {

    private final TicketRepository ticketRepository;
    private final ParkingServiceImpl parkingService;
    private final PriceRepository priceRepository;

    private List<PaymentRule> rules;

    public ParkingTerminalServiceImpl(TicketRepository ticketRepository, ParkingServiceImpl parkingService, PriceRepository priceRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingService = parkingService;
        this.priceRepository = priceRepository;

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
                .forEach(rule -> rule.calculateClientPayment(ticket, priceRepository));
        ticketRepository.deleteById(id);

        return ticket.getPayment();
    }


}
