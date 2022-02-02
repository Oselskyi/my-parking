package com.parking.myparking.controller;

import com.parking.myparking.model.Car;
import com.parking.myparking.model.Ticket;
import com.parking.myparking.services.cars.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    CarService carService;

    @InjectMocks
    CarController controller;

    List<Car> cars;
    MockMvc mockMvc;
    @BeforeEach
    void setUp() {

        cars = new ArrayList<>();
        cars.add(Car.builder()
                .id(1L)
                .brand("bmw").carNumber("123").color("das")
                .ticket(new Ticket()).build());
        cars.add(Car.builder()
                .id(2L)
                .brand("audi").carNumber("567").color("fas")
                .ticket(new Ticket()).build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAll() throws Exception {
        when(carService.showAllCars()).thenReturn(cars);
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk());

    }

//    @Test
//    void getAllByCarNumber() throws Exception {
//        when(carService.getCar(anyLong())).thenReturn(new Car());
//        mockMvc.perform(get("/cars/id"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void createCars() throws Exception {
//        when(carService.enter(any())).thenReturn(new Car());
//        mockMvc.perform(post("/cars/add"))
//                .andExpect(status().isOk());
//    }

    @Test
    void deleteCar() {
    }

}