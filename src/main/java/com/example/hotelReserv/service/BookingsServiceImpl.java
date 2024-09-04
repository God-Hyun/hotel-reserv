package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.BookingDTO;
import com.example.hotelReserv.entity.Bookings;
import com.example.hotelReserv.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingsServiceImpl implements BookingsService {

    @Autowired
    private BookingsRepository bookingsRepository;


    @Override
    public List<BookingDTO> getAllBookings() {
        List<Bookings> bookings = bookingsRepository.findAll();
        return bookings.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<BookingDTO> getBookingById(Long id) {
        return bookingsRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        Bookings bookings = convertToEntity(bookingDTO);
        Bookings saveBooking = bookingsRepository.save(bookings);
        return convertToDto(saveBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingsRepository.deleteById(id);
    }

    @Override
    public List<BookingDTO> getBookingsByUsername(String username) {
        List<Bookings> bookings = bookingsRepository.findByGuestUsername(username); // username으로 예약 조회
        return bookings.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private BookingDTO convertToDto(Bookings booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setGuestId(booking.getGuest().getId());
        dto.setRoomId(booking.getRoom().getId());
        dto.setCheckInDate(booking.getCheckInDate());
        dto.setCheckOutDate(booking.getCheckOutDate());
        dto.setStatus(booking.getStatus());
        return dto;
    }

    private Bookings convertToEntity(BookingDTO dto) {
        Bookings booking = new Bookings();
        booking.setId(dto.getId());
        // guest와 room 엔티티는 데이터베이스에서 조회 후 설정
        booking.setCheckInDate(dto.getCheckInDate());
        booking.setCheckOutDate(dto.getCheckOutDate());
        booking.setStatus(dto.getStatus());
        return booking;
    }
}
