package com.example.hotelReserv.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean isAdmin;
    private String password;  // 암호 필드 추가
}
