package com.parking.myparking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Entity
public class Ticket{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime finishTime;

    @JsonBackReference
    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private Car car;

    public Ticket(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Ticket() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", car=" + car +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(startTime, ticket.startTime) && Objects.equals(finishTime, ticket.finishTime) && Objects.equals(car, ticket.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, finishTime, car);
    }
}
