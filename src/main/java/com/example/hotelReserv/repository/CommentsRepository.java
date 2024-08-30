package com.example.hotelReserv.repository;

import com.example.hotelReserv.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Key;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
