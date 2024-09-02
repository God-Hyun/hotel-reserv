package com.example.hotelReserv.controller;

import com.example.hotelReserv.DTO.BookingDTO;
import com.example.hotelReserv.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @GetMapping("/main")
    public String mainPage() {
        return "index";  // index.html 파일을 렌더링
    }

    // 예약 목록을 보여주는 메서드
    @GetMapping("/list")
    public String reservationStatusPage(Model model) {
        List<BookingDTO> bookings = bookingsService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "reservation-status";  // reservation-status.html 파일을 렌더링
    }

    // 예약 생성 폼을 보여주는 메서드
    @GetMapping("/create")
    public String makeReservationPage(Model model) {
        model.addAttribute("booking", new BookingDTO());
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




    @GetMapping("/vip-room")
    public String vipRoomPage() {
        return "vip-room";  // vip-room.html 파일을 렌더링
    }

    @GetMapping("/standard-room")
    public String standardRoomPage() {
        return "standard-room";  // standard-room.html 파일을 렌더링
    }

    @GetMapping("/special-room")
    public String hanlizRoomPage() {
        return "special-room";  // specialroom.html 파일을 렌더링
    }

    @GetMapping("/directions")
    public String directionsPage() {
        return "directions";  // directions.html 파일을 렌더링
    }

    @GetMapping("/public-transport")
    public String publicTransportPage() {
        return "public-transport";  // public-transport.html 파일을 렌더링
    }

    @GetMapping("/by-car")
    public String byCarPage() {
        return "by-car";  // by-car.html 파일을 렌더링
    }

    @GetMapping("/katsuo-omoi")
    public String katsuoOmoiPage() {
        return "katsuo-omoi";  // katsuo-omoi.html 파일을 렌더링
    }

    @GetMapping("/changgok-stream")
    public String changkyoStreamPage() {
        return "changgok-stream";  // changgok-stream.html 파일을 렌더링
    }

    @GetMapping("/central-plaza")
    public String centralPlazaPage() {
        return "central-plaza";  // central-plaza.html 파일을 렌더링
    }

    @GetMapping("/admin-management")
    public String adminManagementPage() {
        return "admin-management";  // admin-management.html 파일을 렌더링
    }

    @GetMapping("/admin-logout")
    public String adminLogoutPage() {
        return "admin-logout";  // admin-logout.html 파일을 렌더링
    }

    @GetMapping("/resort-news")
    public String resortNewsPage() {
        return "resort-news";  // resort-news.html 파일을 렌더링
    }

    @GetMapping("/reviews")
    public String reviewsPage() {
        return "reviews";  // reviews.html 파일을 렌더링
    }
}
