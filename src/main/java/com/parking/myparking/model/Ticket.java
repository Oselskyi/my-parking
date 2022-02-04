package com.parking.myparking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_number")
    private int ticketNumber;

    @Column(name = "enter_time")
    private LocalDateTime enterTime;

    @ManyToOne
    @JoinColumn(name = "parking_terminal_id")
    @JsonIgnore
    private ParkingTerminal parkingTerminal;


}
