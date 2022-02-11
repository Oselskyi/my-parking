package com.parking.myparking.repository;

import com.parking.myparking.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceRepository extends JpaRepository<Price, Long> {

}
