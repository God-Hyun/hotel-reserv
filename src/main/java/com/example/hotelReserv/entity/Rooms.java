package com.example.hotelReserv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Rooms")
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number", nullable = false ,length = 20)
    private String roomNumber;

    @Column(name = "room_type", nullable = false ,length = 50)
    private String roomType;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "status", length = 30)
    private String status;

    @OneToMany(mappedBy = "room")
    private List<Bookings> bookings;
}
