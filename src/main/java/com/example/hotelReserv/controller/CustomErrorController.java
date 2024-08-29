package com.example.hotelReserv.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // 에러 발생 시 표시할 페이지를 리턴
        return "error"; // error.html 템플릿을 사용
    }
}
