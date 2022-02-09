package com.parking.myparking.repository;

import com.parking.myparking.model.ParkingTerminal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParkingTerminalRepository extends JpaRepository<ParkingTerminal, Long> {
    ParkingTerminal findByName(String name);
}
