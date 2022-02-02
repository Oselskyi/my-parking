package com.parking.myparking.services.cars;

import com.parking.myparking.model.Car;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.CarRepository;
import com.parking.myparking.services.tickets.TicketService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final TicketService ticketService;

    public CarServiceImpl(CarRepository carRepository, @Qualifier("frontTicketService") TicketService ticketService) {
        this.carRepository = carRepository;
        this.ticketService = ticketService;
    }

    @Override
    public List<Car> showAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCar(Long id) {
        Optional<Car> optionalCar = Optional.of(carRepository.getById(id));
        return optionalCar.orElse(null);
    }

    @Override
    public Car enter(Car car) {
        Ticket ticket = ticketService.createTicket(car);
        car.setTicket(ticket);
        return carRepository.save(car);
    }

    @Override
    public void exit(Car car) {
        carRepository.delete(car);
    }

}
