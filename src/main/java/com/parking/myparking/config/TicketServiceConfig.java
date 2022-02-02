package com.parking.myparking.config;

import com.parking.myparking.repository.TicketRepository;
import com.parking.myparking.services.tickets.TicketService;
import com.parking.myparking.services.tickets.TicketServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TicketServiceConfig {

    @Profile("back")
    @Bean(name = "backTicketService")
    TicketService backTicketService(TicketServiceFactory ticketServiceFactory, TicketRepository ticketRepository) {
        return ticketServiceFactory.getTicketService("back", ticketRepository);
    }

    @Profile({"front", "default"})
    @Bean(name = "frontTicketService")
    TicketService frontTicketService(TicketServiceFactory ticketServiceFactory,TicketRepository ticketRepository){
        return ticketServiceFactory.getTicketService("front", ticketRepository);    }

    @Bean
    TicketServiceFactory ticketServiceFactory(){
        return new TicketServiceFactory();
    }
}
