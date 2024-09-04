package com.example.hotelReserv.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class BookingDTO {
    private Long id;
    private Long guestId;   // User 엔티티의 ID를 참조
    private Long roomId;    // Rooms 엔티티의 ID를 참조
    private Date checkInDate;
    private Date checkOutDate;
    private Long status;
    private String roomType; // 객실 유형
    private String name;    // 추가된 필드
    private String phone;   // 추가된 필드

    private RoomDTO room; // RoomDTO 추가
    private UserDTO user; // UserDTO 추가
}
