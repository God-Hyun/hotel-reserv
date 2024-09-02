package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.RoomDTO;
import com.example.hotelReserv.entity.Rooms;
import com.example.hotelReserv.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoomsServiceImpl implements RoomsService{

    @Autowired
    private RoomsRepository roomsRepository;

    @Override
    public List<RoomDTO> getAllRooms() {
        List<Rooms> rooms = roomsRepository.findAll();
        return rooms.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<RoomDTO> getRoomById(Long id) {
        return roomsRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public RoomDTO saveRoom(RoomDTO roomDTO) {
        Rooms room = convertToEntity(roomDTO);
        Rooms savedRoom = roomsRepository.save(room);
        return convertToDTO(savedRoom);
    }

    @Override
    public void deleteRoom(Long id) {
        roomsRepository.deleteById(id);
    }

    private RoomDTO convertToDTO(Rooms room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setRoomType(room.getRoomType());
        dto.setPrice(room.getPrice());
        dto.setStatus(room.getStatus());
        return dto;
    }

    private Rooms convertToEntity(RoomDTO dto) {
        Rooms room = new Rooms();
        room.setId(dto.getId());
        room.setRoomNumber(dto.getRoomNumber());
        room.setRoomType(dto.getRoomType());
        room.setPrice(dto.getPrice());
        room.setStatus(dto.getStatus());
        return room;
    }

}
