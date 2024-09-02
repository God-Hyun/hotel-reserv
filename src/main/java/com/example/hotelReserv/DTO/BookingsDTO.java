package com.example.hotelReserv.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class BookingsDTO {
    private Long id;
    private Long guestId;   // User 엔티티의 ID를 참조
    private Long roomId;    // Rooms 엔티티의 ID를 참조
    private Date checkInDate;
    private Date checkOutDate;
    private String status;
}
