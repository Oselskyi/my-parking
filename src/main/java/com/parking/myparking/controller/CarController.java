package com.parking.myparking.controller;

import com.parking.myparking.model.Car;
import com.parking.myparking.services.CarService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<Car> getAll(){
        return carService.findAll();
    }

    @GetMapping("{id}")
    public Car getAllByCarNumber(@PathVariable("id") Long id){
        return carService.getCar(id);
    }

    @PostMapping("/add")
    public Car createCars(@RequestBody Car car){
        return carService.goIn(car);
    }

    @DeleteMapping("/delete")
    public void deleteCar(@RequestBody Car car){
        carService.delete(car);
    }
    @DeleteMapping("/delete, {id}")
    public void deleteCarById(@PathVariable Long id){
        carService.deleteById(id);
    }

}
