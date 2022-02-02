package com.parking.myparking.model;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;
    @BeforeEach
    public void setUp(){
        car = new Car();
    }

    @Test
    void getId() throws Exception{
        Long idValue = 4L;
        car.setId(idValue);

        assertEquals(idValue, car.getId());
    }

    @Test
    void getBrand() {
    }

    @Test
    void getTicket() {
    }
}