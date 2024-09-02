package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.BoardDTO;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<BoardDTO> getAllBoards();
    Optional<BoardDTO> getBoardById(Long id);
    BoardDTO saveBoard(BoardDTO boardDTO);
    void deleteBoard(Long id);
}
