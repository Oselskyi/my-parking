package com.parking.myparking.repository;

import com.parking.myparking.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Long> {

}
