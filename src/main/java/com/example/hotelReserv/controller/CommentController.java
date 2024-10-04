package com.example.hotelReserv.controller;

import com.example.hotelReserv.DTO.CommentDTO;
import com.example.hotelReserv.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 특정 게시글의 댓글 목록 보기
    @GetMapping("/post/{postId}")
    public String showComments(@PathVariable Long postId, Model model) {
        List<CommentDTO> comments = commentService.getAllComment().stream()
                .filter(comment -> comment.getPostId().equals(postId))
                .toList();
        model.addAttribute("comments", comments);
        return "comments"; // 댓글 목록 페이지 렌더링
    }

    // 댓글 작성 처리
    @PostMapping("/create")
    public String createComment(@ModelAttribute("commentDTO") CommentDTO commentDTO, Authentication authentication) {
        String username = authentication.getName(); // 로그인한 유저의 이름 가져오기
        commentDTO.setAuthor(username); // 댓글 작성자 설정

        commentService.saveComment(commentDTO);
        return "redirect:/comments/post/" + commentDTO.getPostId(); // 댓글 작성 후 리디렉션
    }

    // 댓글 삭제
    @GetMapping("/delete/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return "redirect:/comments";
    }
}
