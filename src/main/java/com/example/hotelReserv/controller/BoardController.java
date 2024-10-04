package com.example.hotelReserv.controller;

import com.example.hotelReserv.DTO.BoardDTO;
import com.example.hotelReserv.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    // 공지사항 페이지
    @GetMapping("/resort-news")
    public String showResortNews(Model model) {
        List<BoardDTO> boards = boardService.getAllBoards().stream()
                .filter(board -> board.getType().equals("공지사항"))
                .toList();
        model.addAttribute("boards", boards);
        return "resort-news"; // 공지사항 페이지 렌더링
    }

    // 이용후기 페이지
    @GetMapping("/reviews")
    public String showReviews(Model model) {
        List<BoardDTO> boards = boardService.getAllBoards().stream()
                .filter(board -> board.getType().equals("이용후기"))
                .toList();
        model.addAttribute("boards", boards);
        return "reviews"; // 이용후기 페이지 렌더링
    }

    // 게시글 작성 페이지
    @GetMapping("/create")
    public String createBoardForm(Model model) {
        model.addAttribute("boardDTO", new BoardDTO());
        return "create-board"; // 게시글 작성 페이지 렌더링
    }

    // 게시글 작성 처리
    @PostMapping("/create")
    public String createBoard(@ModelAttribute("boardDTO") BoardDTO boardDTO, Authentication authentication) {
        // 공지사항 작성 권한 체크
        if (boardDTO.getType().equals("공지사항")) {
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
                return "redirect:/error/forbidden"; // 권한 없음 에러 페이지로 리디렉션
            }
        } else if (boardDTO.getType().equals("이용후기")) {
            // 일반 사용자는 이용후기 작성 가능
            boardService.saveBoard(boardDTO);
            return "redirect:/boards/reviews"; // 이용후기 작성 후 이용후기 페이지로 리디렉션
        } else {
            return "redirect:/error/forbidden"; // 권한 없음 에러 페이지
        }

        // 공지사항 작성 후 리디렉션
        boardService.saveBoard(boardDTO);
        return "redirect:/boards/resort-news";
    }

    // 게시글 삭제 (관리자만 삭제 가능하게 추가 가능)
    @GetMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id, Authentication authentication) {
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        // 관리자만 게시글 삭제 가능
        if (isAdmin) {
            boardService.deleteBoard(id);
            return "redirect:/boards";
        } else {
            return "redirect:/error/forbidden"; // 권한 없음 에러 페이지
        }
    }
}
