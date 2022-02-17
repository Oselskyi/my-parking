package com.parking.myparking.services;

import com.parking.myparking.model.ParkingTerminal;
import com.parking.myparking.model.Price;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.PriceRepository;
import com.parking.myparking.repository.TicketRepository;
import com.parking.myparking.rules.*;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ParkingTerminalServiceImpl implements ParkingTerminalService {

    private final TicketRepository ticketRepository;
    private final ParkingService parkingService;
    private final PriceRepository priceRepository;


    private List<PaymentRule> rules;

    public ParkingTerminalServiceImpl(TicketRepository ticketRepository, ParkingService parkingService, PriceRepository priceRepository) {
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
        ParkingTerminal parkingTerminal=parkingService.getTerminalByName("back");
        Ticket newTicket = Ticket.forEntry(parkingTerminal);
        ticketRepository.save(newTicket);

        return newTicket;
    }

    @Override
    public Double exit(Long id) {

        Ticket ticket = ticketRepository.getById(id);
        Price price = ticket.getParkingTerminal().getPrice();

        rules.stream()
                .filter(rule -> rule.shouldRun(ticket))
                .forEach(rule -> rule.calculateClientPayment(ticket, price));
        ticketRepository.deleteById(id);

        return ticket.getPayment();
    }


}
