package com.example.hotelReserv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

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
