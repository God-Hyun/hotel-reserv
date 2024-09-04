package com.example.hotelReserv.controller;

import com.example.hotelReserv.DTO.BookingDTO;
import com.example.hotelReserv.DTO.RoomDTO;
import com.example.hotelReserv.service.BookingsService;
import com.example.hotelReserv.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @Autowired
    private RoomsService roomsService; // RoomsService 추가

    // 예약 목록을 보여주는 메서드
    @GetMapping("/list")
    public String reservationStatusPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        boolean isAdmin = authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        List<BookingDTO> bookings;
        if (isAdmin) {
            bookings = bookingsService.getAllBookings(); // 관리자는 모든 예약 조회
        } else {
            bookings = bookingsService.getBookingsByUsername(username); // 사용자는 자신의 예약만 조회
        }

        model.addAttribute("bookings", bookings);
        return "reservation-status";  // reservation-status.html 파일을 렌더링
    }

    // 예약 생성 폼을 보여주는 메서드
    @GetMapping("/create")
    public String makeReservationPage(Model model) {
        List<RoomDTO> rooms = roomsService.getAllRooms(); // 모든 방 정보 조회
        model.addAttribute("rooms", rooms); // 방 리스트를 모델에 추가
        model.addAttribute("booking", new BookingDTO()); // BookingDTO 추가
        return "make-reservation";  // make-reservation.html 파일을 렌더링
    }

    // 예약 폼 데이터를 받아 처리하는 메서드
    @PostMapping("/submit-reservation")
    public String submitReservation(@ModelAttribute("booking") BookingDTO bookingDTO) {
        bookingsService.saveBooking(bookingDTO);
        return "redirect:/bookings/list";
    }

    // 기존 예약을 수정하기 위한 폼을 보여주는 메서드
    @GetMapping("/edit/{id}")
    public String editBooking(@PathVariable Long id, Model model) {
        BookingDTO bookingDTO = bookingsService.getBookingById(id).orElse(new BookingDTO());
        model.addAttribute("booking", bookingDTO);
        return "make-reservation";
    }

    // 특정 예약을 삭제하는 메서드
    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingsService.deleteBooking(id);
        return "redirect:/bookings/list";
    }





}
