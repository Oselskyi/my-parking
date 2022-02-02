package com.parking.myparking.services.tickets;

import com.parking.myparking.repository.TicketRepository;

public class TicketServiceFactory {

    public TicketService getTicketService(String ticketService, TicketRepository ticketRepository){
        switch (ticketService){
            case "front":
                return new FrontTicketService(ticketRepository);
            case "back":
                return new BackTicketService(ticketRepository);
            default:
                return new FrontTicketService(ticketRepository);
        }
    }
}
