package com.parking.myparking.bootstrap;

import com.parking.myparking.services.cars.CarService;
import com.parking.myparking.services.tickets.TicketService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ServiceLoader implements CommandLineRunner {

    private final CarService carService;
    private final TicketService frontTicketService;
    private final TicketService backTicketService;

    public ServiceLoader(CarService carService, TicketService frontTicketService, TicketService backTicketService) {
        this.carService = carService;
        this.frontTicketService = frontTicketService;
        this.backTicketService = backTicketService;
    }

//    public ServiceLoader() {
//        carService = new CarServiceImpl();
//        frontTicketService = new FrontTicketService();
//        backTicketService = new BackTicketService();
//    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Do something with starting project...");
    }
}
