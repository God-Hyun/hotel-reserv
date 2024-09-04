package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.UserDTO;
import com.example.hotelReserv.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();
    Optional<UserDTO> getUserById(Long id);
    UserDTO saveUser(UserDTO userDTO);
    void deleteUser(Long id);
    void registerUser(UserDTO userDTO);

    User findByUsername(String username);
}
