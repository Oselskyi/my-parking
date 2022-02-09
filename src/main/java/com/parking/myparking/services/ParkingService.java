package com.parking.myparking.services;

import com.parking.myparking.model.ParkingTerminal;

import java.util.List;

public interface ParkingService {
    List<ParkingTerminal> showAllTerminals();

    ParkingTerminal createNewTerminal(String name);

    ParkingTerminal getTerminalByName(String name);

}
