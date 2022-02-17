package com.parking.myparking.services;

import com.parking.myparking.repository.ParkingTerminalRepository;
import org.springframework.stereotype.Service;

import com.parking.myparking.model.ParkingTerminal;

import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingTerminalRepository parkingTerminalRepository;

    public ParkingServiceImpl(ParkingTerminalRepository parkingTerminalRepository) {
        this.parkingTerminalRepository = parkingTerminalRepository;
    }

    @Override
    public List<ParkingTerminal> showAllTerminals() {
        return parkingTerminalRepository.findAll();
    }

    @Override
    public ParkingTerminal createNewTerminal(String name) {

        ParkingTerminal parkingTerminal = new ParkingTerminal();

        if (parkingTerminalRepository.findByName(name) == null) {
            parkingTerminal.setName(name);
            parkingTerminalRepository.save(parkingTerminal);
            return parkingTerminal;
        } else {
            return getTerminalByName(name);
        }

    }

    @Override
    public ParkingTerminal getTerminalByName(String name) {
        if (parkingTerminalRepository.findByName(name) == null){
            System.out.println("OSHYBKA");
            //throw Exception
        }
        return parkingTerminalRepository.findByName(name);
    }
}
