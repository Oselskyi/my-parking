package com.parking.myparking.services;

import com.parking.myparking.model.ParkingTerminal;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.ParkingTerminalRepository;
import com.parking.myparking.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParkingTerminalServiceImpl implements ParkingTerminalService {

    private final ParkingTerminalRepository parkingTerminalRepository;
    private final TicketRepository ticketRepository;

    public ParkingTerminalServiceImpl(ParkingTerminalRepository parkingTerminalRepository, TicketRepository ticketRepository) {
        this.parkingTerminalRepository = parkingTerminalRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> showAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket enter( ) {
        Ticket newTicket = new Ticket();
        int number = (int) (Math.random() * 100);
        newTicket.setTicketNumber(number);
        newTicket.setEnterTime(LocalDateTime.now());
        ParkingTerminal parkingTerminal = new ParkingTerminal();
        parkingTerminal.setName("magic terminal");
        parkingTerminalRepository.save(parkingTerminal);
        newTicket.setParkingTerminal(parkingTerminal);
        ticketRepository.save(newTicket);

        return newTicket;
    }

    @Override
    public Double exit(Long id) {
        double sum = payment(ticketRepository.getById(id));
        ticketRepository.deleteById(id);
        return sum;
    }

    private Double payment(Ticket ticket) {
        int timeVisit = LocalDateTime.now().getHour() - (ticket.getEnterTime().getHour());

        double payment;
        if (timeVisit > 1 && timeVisit <= 5) {
            payment = timeVisit * 10;
            return payment;
        } else if (timeVisit <= 16) {
            payment = timeVisit * 15;
            return payment;
        } else {
            payment = timeVisit * 20;
            return payment;
        }
    }
}
