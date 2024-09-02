package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.CommentDTO;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentDTO> getAllComment();
    Optional<CommentDTO> getCommentById(Long id);
    CommentDTO saveComment(CommentDTO commentDTO);
    void deleteComment(Long id);
}
