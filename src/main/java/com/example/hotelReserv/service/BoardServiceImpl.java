package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.BoardDTO;
import com.example.hotelReserv.entity.Board;
import com.example.hotelReserv.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<BoardDTO> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<BoardDTO> getBoardById(Long id) {
        return boardRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public BoardDTO saveBoard(BoardDTO boardDTO) {
        Board board = convertToEntity(boardDTO);
        Board savedBoard = boardRepository.save(board);
        return convertToDTO(savedBoard);
    }

    @Override
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    private BoardDTO convertToDTO(Board board) {
        BoardDTO dto = new BoardDTO();
        dto.setId(board.getId());
        dto.setAuthorId(board.getAuthor().getId());
        dto.setTitle(board.getTitle());
        dto.setContent(board.getContent());
        dto.setType(board.getType());
        dto.setCreatedAt(board.getCreatedAt());
        dto.setUpdatedAt(board.getUpdatedAt());
        return dto;
    }

    private Board convertToEntity(BoardDTO dto) {
        Board board = new Board();
        board.setId(dto.getId());
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        board.setType(dto.getType());
        board.setType(dto.getType());
        board.setCreatedAt(dto.getCreatedAt());
        board.setUpdatedAt(dto.getUpdatedAt());
        return board;
    }
}
