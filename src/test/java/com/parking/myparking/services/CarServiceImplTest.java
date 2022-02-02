package com.parking.myparking.services;

import com.parking.myparking.model.Car;
import com.parking.myparking.repository.CarRepository;
import com.parking.myparking.services.cars.CarServiceImpl;
import com.parking.myparking.services.tickets.FrontTicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CarServiceImplTest {

    CarServiceImpl carService;

    final Long carId = 1L;

    @Mock
    CarRepository carRepository;

    @Mock
    FrontTicketService ticketService;

    Car returnCar;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        carService = new CarServiceImpl(carRepository, ticketService);
      //  returnCar = carService.save(Car.builder().id(carId).brand("bmw").carNumber("1234").color("black").ticket(new Ticket(LocalDateTime.now())).build());
    }

    @Test
    void findAll() {
        List<Car> carList = new ArrayList<>();
        Car car = new Car();
        carList.add(car);

        when(carService.showAllCars()).thenReturn(carList);
        List<Car> carListTest = carService.showAllCars();

        assertEquals(1, carListTest.size());

    }

    @Test
    void getCar() {
//        when(carRepository.getById(anyLong())).thenReturn(returnCar);
//        Car car = carService.getCar(carId);
//        assertEquals(carId, car.getId());
        Car car1 = new Car();
        car1.setId(1L);
        when(carRepository.getById(any())).thenReturn(car1);
        Car car = carService.getCar(carId);
        assertEquals(car.getId(), car1.getId());
        verify(carRepository).getById(any());
    }

    @Test
    void goIn() {
        Car car = new Car();
        when(carRepository.save(any())).thenReturn(new Car());
        Car expectedCar = new Car();
        assertEquals(expectedCar, car);
    }

    @Test
    void delete() {
    }

}