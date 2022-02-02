package com.parking.myparking.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "color")
    private String color;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;

    public Car() {
    }

    public Car(Long id, String brand, String carNumber, String color, Ticket ticket) {
        this.id = id;
        this.brand = brand;
        this.carNumber = carNumber;
        this.color = color;
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(brand, car.brand) && Objects.equals(carNumber, car.carNumber) && Objects.equals(color, car.color) && Objects.equals(ticket, car.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, carNumber, color, ticket);
    }
}
