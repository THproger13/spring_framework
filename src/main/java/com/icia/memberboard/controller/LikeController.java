package com.icia.memberboard.controller;

import com.icia.memberboard.dto.LikeDTO;
import com.icia.memberboard.service.BoardService;
import com.icia.memberboard.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Like")
public class LikeController {
    @Autowired
    private LikeService likeService;
    @Autowired
    private BoardService boardService;

    @PostMapping("/like")
    @ResponseBody
    public Map<String, Object> like(@RequestParam Long boardId,
                                @RequestParam boolean isClicked,
                                    HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        try {
            String loginEmail = (String) session.getAttribute("loginEmail");

            // DB에서 현재 loginEmail과 boardId에 해당하는 레코드를 찾음.
            LikeDTO likeDTO = likeService.findById(boardId, loginEmail);

            if (likeDTO == null && isClicked == false ) {
                // 좋아요를 처음 누르는 경우
                likeService.save(boardId, loginEmail); // DB에 추가
                boardService.upLikeHits(boardId); // likeCount 증가
                Long likeHits = boardService.getLikeHits(boardId);
                System.out.println(likeHits);
                response.put("success", true);
                response.put("likeHits", likeHits);
                response.put("isClicked", true);
            } else if (likeDTO != null && isClicked == false) {
                //좋아요를 누르지 않은 경우
                boardService.upLikeHits(boardId);   // likeCount 증가
                Long likeHits = boardService.getLikeHits(boardId);
                System.out.println(likeHits);
                response.put("success", true);
                response.put("likeHits", likeHits);
                response.put("isClicked", true);
            } else {
                // 좋아요를 눌러놓은 경우
                // isClicked를 true로 설정
                boardService.downLikeHits(boardId); // likeCount 감소
                Long likeHits = boardService.getLikeHits(boardId);
                System.out.println(likeHits);
                response.put("success", true);
                response.put("likeHits", likeHits);
                response.put("isClicked", false);
            }
        } catch (Exception e) {
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }
        return response;
    }

}
