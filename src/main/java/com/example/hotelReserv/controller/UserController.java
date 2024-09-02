package com.example.hotelReserv.controller;

import com.example.hotelReserv.DTO.UserDTO;
import com.example.hotelReserv.entity.User;
import com.example.hotelReserv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입 폼을 보여주는 메서드
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register"; // register.html 파일을 렌더링
    }

    // 회원가입 요청을 처리하는 메서드
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserDTO userDTO, Model model) {
        try {
            userService.registerUser(userDTO);
            return "redirect:/user/login"; // 회원가입 후 로그인 페이지로 리다이렉트
        } catch (Exception e) {
            model.addAttribute("error", "회원가입 중 오류가 발생했습니다. 다시 시도해주세요.");
            return "register"; // 오류 발생 시 회원가입 페이지로 돌아감
        }
    }

    // 로그인 폼을 보여주는 메서드
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // login.html 파일을 렌더링
    }

    // 로그인 요청을 처리하는 메서드
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password, Model model) {
        boolean isAuthenticated = userService.authenticate(email, password);
        if (isAuthenticated) {
            return "redirect:/bookings/main"; // 로그인 성공 시 메인 페이지로 리다이렉트
        } else {
            model.addAttribute("error", "이메일 또는 비밀번호가 올바르지 않습니다.");
            return "login"; // 로그인 실패 시 다시 로그인 페이지로
        }
    }
}
