package com.parking.myparking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_number")
    private int ticketNumber;

    @Column(name = "enter_time")
    private LocalDateTime enterTime;

    @Column(name = "payment")
    private double payment;

    @ManyToOne
    @JoinColumn(name = "parking_terminal_id")
    @JsonIgnore
    private ParkingTerminal parkingTerminal;

    public static Ticket forEntry(ParkingTerminal terminal) {
        int number = (int) (Math.random() * 100);
        Ticket newTicket = new Ticket();
        newTicket.setTicketNumber(number);
        newTicket.setEnterTime(LocalDateTime.now().minusHours(4));
        newTicket.setParkingTerminal(terminal);

        return newTicket;
    }
}
