package com.example.hotelReserv.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {
    private Long id;
    private Long postId;  // Board 엔티티의 ID를 참조
    private String author;
    private String content;
    private Date createdAt;
}
