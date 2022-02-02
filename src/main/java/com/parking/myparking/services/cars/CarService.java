package com.parking.myparking.services.cars;

import com.parking.myparking.model.Car;

import java.util.List;


public interface CarService {

    List<Car> showAllCars();
    Car getCar(Long id); //TODO: getCarByCarNumber
    Car enter(Car object);
    void exit(Car car);
}
