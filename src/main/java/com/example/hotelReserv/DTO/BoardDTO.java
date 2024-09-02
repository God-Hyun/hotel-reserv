package com.example.hotelReserv.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDTO {
    private Long id;
    private Long authorId;
    private String title;
    private String content;
    private String type;
    private Date createdAt;
    private Date updatedAt;
}
