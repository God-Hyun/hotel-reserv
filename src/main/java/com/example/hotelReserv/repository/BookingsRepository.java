package com.example.hotelReserv.repository;

import com.example.hotelReserv.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {
    List<Bookings> findByGuestUsername(String username); // User 엔티티에 username 필드가 있다.
}
