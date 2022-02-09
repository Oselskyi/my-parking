package com.parking.myparking.controller;

import com.parking.myparking.model.Ticket;
import com.parking.myparking.services.ParkingTerminalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class ParkingController {

    private final ParkingTerminalService parkingTerminalService;

    public ParkingController(ParkingTerminalService parkingTerminalService) {
        this.parkingTerminalService = parkingTerminalService;
    }

    @GetMapping
    public List<Ticket> showAllTickets() {
        return parkingTerminalService.showAllTickets();
    }

    @PostMapping
    public Integer enter() {

        Ticket ticket = parkingTerminalService.enter();
        return ticket.getTicketNumber();
    }

    @DeleteMapping("/{id}")
    public Double exit(@PathVariable("id") Long id) {

        return parkingTerminalService.exit(id);
    }

}
