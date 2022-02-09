package com.parking.myparking.services;

import com.parking.myparking.model.Ticket;

import java.util.List;

public interface ParkingTerminalService {
    List<Ticket> showAllTickets();

    Ticket enter();

    Double exit(Long id);
}
