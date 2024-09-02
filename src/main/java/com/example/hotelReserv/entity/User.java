package com.example.hotelReserv.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Controller;

import java.util.List;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String first_name;

    @Column(name = "last_name", nullable = false, length = 20)
    private String last_name;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    @Column(name = "password", nullable = false)
    private String password;  // 암호 필드 추가

    @OneToMany(mappedBy = "guest")
    private List<Bookings> bookings;

    @OneToMany(mappedBy = "author")
    private List<Board> posts;

}
