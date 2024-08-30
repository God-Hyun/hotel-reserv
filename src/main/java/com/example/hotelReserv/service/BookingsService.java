package com.example.hotelReserv.service;

import com.example.hotelReserv.entity.Bookings;
import com.example.hotelReserv.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {

    @Autowired
    private BookingsRepository BookingsRepository;

    public List<Bookings> getAllBookings() {
        return BookingsRepository.findAll();
    }

    public Bookings saveBookings(Bookings bookings) {
        return BookingsRepository.save(bookings);
    }
}
