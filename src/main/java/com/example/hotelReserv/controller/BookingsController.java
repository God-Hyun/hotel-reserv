package com.example.hotelReserv.controller;

import com.example.hotelReserv.DTO.BookingDTO;
import com.example.hotelReserv.DTO.RoomDTO;
import com.example.hotelReserv.entity.User;
import com.example.hotelReserv.service.BookingsService;
import com.example.hotelReserv.service.RoomsService;
import com.example.hotelReserv.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @Autowired
    private RoomsService roomsService; // RoomsService 추가

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // 현재 로그인한 사용자 정보를 가져옵니다.
        User user = userService.findByUsername(username);

        // 사용자의 이름과 전화번호를 BookingDTO에 설정합니다.
        BookingDTO bookingDTO = new BookingDTO();
        if (user != null) {
            bookingDTO.setName(user.getFirst_name() + " " + user.getLast_name()); // 이름 설정
            bookingDTO.setPhone(user.getPhone()); // 전화번호 설정
        }

        // 예약 폼에 사용될 객체와 필요한 데이터를 모델에 추가합니다.
        model.addAttribute("booking", bookingDTO);

        List<RoomDTO> rooms = roomsService.getAllRooms(); // 모든 방 정보 조회
        model.addAttribute("rooms", rooms); // 방 리스트를 모델에 추가

        return "make-reservation";  // make-reservation.html 파일을 렌더링
    }

    // 예약 폼 데이터를 받아 처리하는 메서드
    @PostMapping("/submit-reservation")
    public String submitReservation(@ModelAttribute("booking") BookingDTO bookingDTO) {
        log.info("예약 정보: " + bookingDTO.toString());
        if (bookingDTO.getCheckInDate() == null || bookingDTO.getCheckOutDate() == null) {
            return "redirect:/bookings/create?error=true"; // 유효성 검사를 위한 리디렉션
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userService.findByUsername(username);
        if (user != null) {
            bookingDTO.setGuestId(user.getId());
            bookingsService.saveBooking(bookingDTO);
        }

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
