package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.RoomDTO;

import java.util.List;
import java.util.Optional;

public interface RoomsService {
    List<RoomDTO> getAllRooms();
    Optional<RoomDTO> getRoomById(Long id);
    RoomDTO saveRoom(RoomDTO roomDTO);
    void deleteRoom(Long id);
}
