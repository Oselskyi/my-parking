package com.parking.myparking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
public class ParkingConfig {
    Properties property = new Properties();


    int priceForHalfDay;
    int priceForDay;
    int priceMoreThenDay;
    int priceForLost;




    //    Price hourPrice = new Price();
//        hourPrice.setPriceForHalfDay(2);
//        hourPrice.setPriceForDay(3);
//        hourPrice.setPriceMoreThenDay(20);
//        hourPrice.setPriceForLost(50);
//        priceRepository.save(hourPrice);
 }
