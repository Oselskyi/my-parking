package com.parking.myparking.bootstarp;

import com.parking.myparking.model.ParkingTerminal;
import com.parking.myparking.model.Price;
import com.parking.myparking.repository.ParkingTerminalRepository;
import com.parking.myparking.repository.PriceRepository;
import com.parking.myparking.services.PriceTest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader implements CommandLineRunner {

    private final ParkingTerminalRepository parkingTerminalRepository;
    private final PriceRepository priceRepository;
    private final PriceTest priceTest;

    public DataLoader(ParkingTerminalRepository parkingTerminalRepository, PriceRepository priceRepository, PriceTest priceTest) {
        this.parkingTerminalRepository = parkingTerminalRepository;
        this.priceRepository = priceRepository;
        this.priceTest = priceTest;
    }


    @Override
    public void run(String... args) {

        Price price = priceTest.init();
        priceRepository.save(price);

        ParkingTerminal frontTerminal = new ParkingTerminal();
        frontTerminal.setName("front");
        frontTerminal.setPrice(price);
        parkingTerminalRepository.save(frontTerminal);

        ParkingTerminal backTerminal = new ParkingTerminal();
        backTerminal.setName("back");
        backTerminal.setPrice(price);
        parkingTerminalRepository.save(backTerminal);


    }
}
