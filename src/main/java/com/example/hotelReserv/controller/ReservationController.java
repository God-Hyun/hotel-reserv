package com.example.hotelReserv.controller;

import com.example.hotelReserv.entity.Reservation;
import com.example.hotelReserv.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public String getAllReservation(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

    @PostMapping("/reservations")
    public String saveReservation(Reservation reservation) {
        reservationService.saveReservation(reservation);
        return "redirect:/reservations";
    }
}
