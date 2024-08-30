package com.example.hotelReserv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private String guest;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private String room;

    @Column(name = "check_in_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate checkInDate;

    @Column(name = "check_out_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Long checkOutDate;

    @Column(name = "status", length = 30)
    private String status;
}
