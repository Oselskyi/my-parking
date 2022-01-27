package com.parking.myparking.services;

import com.parking.myparking.model.Car;

import java.util.List;


public interface CarService {

    List<Car> findAll();
    Car getCar(Long id);
    Car goIn(Car object);
    void delete(Car car);
    void deleteById(Long id);
}
