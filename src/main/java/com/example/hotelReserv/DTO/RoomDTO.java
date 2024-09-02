package com.example.hotelReserv.DTO;

import lombok.Data;

@Data
public class RoomDTO {
    private Long id;
    private String roomNumber;
    private String roomType;
    private Double price;
    private String status;
}
