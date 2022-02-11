package com.parking.myparking.bootstarp;

import com.parking.myparking.model.ParkingTerminal;
import com.parking.myparking.model.Price;
import com.parking.myparking.repository.ParkingTerminalRepository;
import com.parking.myparking.repository.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader implements CommandLineRunner {

    private final ParkingTerminalRepository parkingTerminalRepository;
    private final PriceRepository priceRepository;

    public DataLoader(ParkingTerminalRepository parkingTerminalRepository, PriceRepository priceRepository) {
        this.parkingTerminalRepository = parkingTerminalRepository;
        this.priceRepository = priceRepository;
    }

    @PostConstruct
    public void init() {
//        Price hourPrice = new Price();
//        hourPrice.setPriceForHalfDay(2);
//        hourPrice.setPriceForDay(3);
//        hourPrice.setPriceMoreThenDay(20);
//        hourPrice.setPriceForLost(50);
//        priceRepository.save(hourPrice);

    }

    @Override
    public void run(String... args) {

        Price hourPrice = new Price();
        hourPrice.setPriceForHalfDay(2);
        hourPrice.setPriceForDay(3);
        hourPrice.setPriceMoreThenDay(20);
        hourPrice.setPriceForLost(50);
        priceRepository.save(hourPrice);



        ParkingTerminal frontTerminal = new ParkingTerminal();
        frontTerminal.setName("front");
        frontTerminal.setPrice(hourPrice);
        parkingTerminalRepository.save(frontTerminal);

        ParkingTerminal backTerminal = new ParkingTerminal();
        backTerminal.setName("back");
        backTerminal.setPrice(hourPrice);
        parkingTerminalRepository.save(backTerminal);


    }
}
