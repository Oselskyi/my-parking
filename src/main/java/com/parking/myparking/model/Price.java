package com.parking.myparking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price_for_half_day")
    private int priceForHalfDay;

    @Column(name = "price_for_day")
    private int priceForDay;

    @Column(name = "price_more_then_day")
    private int priceMoreThenDay;

    @Column(name = "price_for_lost")
    private int priceForLost;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "price")
    private Set<ParkingTerminal> parkingTerminals = new HashSet<>();



}
