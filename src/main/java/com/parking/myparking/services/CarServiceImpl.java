package com.parking.myparking.services;

import com.parking.myparking.model.Car;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final TicketService eastTicketService;
    private final TicketService westTicketService;

    public CarServiceImpl(CarRepository carRepository, TicketService eastTicketService, TicketService westTicketService) {
        this.carRepository = carRepository;
        this.eastTicketService = eastTicketService;
        this.westTicketService = westTicketService;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getCar(Long id) {
        return carRepository.getById(id);
    }

    @Override
    public Car goIn(Car car) {
        Ticket ticket = eastTicketService.createTicket(car);
        car.setTicket(ticket);
        return carRepository.save(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
