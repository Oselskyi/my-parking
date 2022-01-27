package com.parking.myparking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
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

    public Ticket(LocalDateTime startTime, Car car) {
        this.startTime = startTime;
        this.car = car;
    }
}
