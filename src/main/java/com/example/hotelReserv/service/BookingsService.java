package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.BookingDTO;

import java.util.List;
import java.util.Optional;

public interface BookingsService {
    List<BookingDTO> getAllBookings();
    Optional<BookingDTO> getBookingById(Long id);
    BookingDTO saveBooking(BookingDTO bookingDTO);
    void deleteBooking(Long id);
    List<BookingDTO> getBookingsByUsername(String username); // 사용자 이름으로 예약 조회
}
