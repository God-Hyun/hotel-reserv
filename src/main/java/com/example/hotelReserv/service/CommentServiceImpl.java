package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.CommentDTO;
import com.example.hotelReserv.entity.Comments;
import com.example.hotelReserv.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<CommentDTO> getAllComment() {
        List<Comments> comments = commentsRepository.findAll();
        return comments.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<CommentDTO> getCommentById(Long id) {
        return commentsRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public CommentDTO saveComment(CommentDTO commentDTO) {
        Comments comments = convertToEntity(commentDTO);
        Comments savedComments = commentsRepository.save(comments);
        return convertToDTO(savedComments);
    }

    @Override
    public void deleteComment(Long id) {
        commentsRepository.deleteById(id);
    }

    private CommentDTO convertToDTO(Comments comments) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comments.getId());
        dto.setPostId(comments.getPost().getId());
        dto.setAuthor(comments.getAuthor());
        dto.setContent(comments.getContent());
        dto.setCreatedAt(comments.getCreateAt());
        return dto;
    }

    private Comments convertToEntity(CommentDTO dto) {
        Comments comments = new Comments();
        comments.setId(dto.getId());
        // Post 설정은 외부에서 엔티티를 조회한 후 설정
        comments.setAuthor(dto.getAuthor());
        comments.setContent(dto.getContent());
        comments.setCreateAt(dto.getCreatedAt());
        return comments;
    }
}
