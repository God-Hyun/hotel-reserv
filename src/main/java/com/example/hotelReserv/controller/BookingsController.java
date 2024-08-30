package com.example.hotelReserv.controller;

import com.example.hotelReserv.entity.Bookings;
import com.example.hotelReserv.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @GetMapping("/main")
    public String mainPage() {
        return "index";  // index.html 파일을 렌더링
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

    @GetMapping("/reservation-status")
    public String reservationStatusPage() {
        return "reservation-status";  // reservation-status.jsp 파일을 렌더링
    }

    @GetMapping("/make-reservation")
    public String makeReservationPage() {
        return "make-reservation";  // make-reservation.jsp 파일을 렌더링
    }

    @GetMapping("/admin-management")
    public String adminManagementPage() {
        return "admin-management";  // admin-management.jsp 파일을 렌더링
    }

    @GetMapping("/admin-logout")
    public String adminLogoutPage() {
        return "admin-logout";  // admin-logout.jsp 파일을 렌더링
    }

    @GetMapping("/resort-news")
    public String resortNewsPage() {
        return "resort-news";  // resort-news.jsp 파일을 렌더링
    }

    @GetMapping("/reviews")
    public String reviewsPage() {
        return "reviews";  // reviews.jsp 파일을 렌더링
    }
}
