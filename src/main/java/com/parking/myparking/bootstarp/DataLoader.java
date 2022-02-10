package com.parking.myparking.bootstarp;

import com.parking.myparking.model.ParkingTerminal;
import com.parking.myparking.model.Price;
import com.parking.myparking.repository.ParkingTerminalRepository;
import com.parking.myparking.repository.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ParkingTerminalRepository parkingTerminalRepository;
    private final PriceRepository priceRepository;

    public DataLoader(ParkingTerminalRepository parkingTerminalRepository, PriceRepository priceRepository) {
        this.parkingTerminalRepository = parkingTerminalRepository;
        this.priceRepository = priceRepository;
    }

    @Override
    public void run(String... args) {

        ParkingTerminal frontTerminal = new ParkingTerminal();
        frontTerminal.setName("front");
        parkingTerminalRepository.save(frontTerminal);

        ParkingTerminal backTerminal = new ParkingTerminal();
        backTerminal.setName("back");
        parkingTerminalRepository.save(backTerminal);


        Price hourPrice = new Price();
        hourPrice.setName("ForHalfDay");
        hourPrice.setPrice(2);
        priceRepository.save(hourPrice);

        Price hourPriceForDay = new Price();
        hourPriceForDay.setName("ForDay");
        hourPriceForDay.setPrice(3);
        priceRepository.save(hourPriceForDay);

        Price priceForDay = new Price();
        priceForDay.setName("ForMoreThanDay");
        priceForDay.setPrice(20);
        priceRepository.save(priceForDay);

        Price priceForLost = new Price();
        priceForLost.setName("ForLost");
        priceForLost.setPrice(50);
        priceRepository.save(priceForLost);


    }
}
