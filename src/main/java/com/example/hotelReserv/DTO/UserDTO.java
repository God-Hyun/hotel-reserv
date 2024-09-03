package com.example.hotelReserv.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String phone;
    private String role;
    private String password;  // 암호 필드 추가
}
