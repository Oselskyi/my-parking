package com.parking.myparking.bootstarp;

import com.parking.myparking.model.ParkingTerminal;
import com.parking.myparking.repository.ParkingTerminalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ParkingTerminalRepository parkingTerminalRepository;

    public DataLoader(ParkingTerminalRepository parkingTerminalRepository) {
        this.parkingTerminalRepository = parkingTerminalRepository;
    }

    @Override
    public void run(String... args) {

        ParkingTerminal parkingTerminal = new ParkingTerminal();
        parkingTerminal.setId(1L);
        parkingTerminal.setName("front");
        parkingTerminalRepository.save(parkingTerminal);
    }
}
