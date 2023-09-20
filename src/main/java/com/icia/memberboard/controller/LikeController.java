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
import java.util.List;
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
            List<LikeDTO> likeDTOList = likeService.findById(boardId, loginEmail);

            if (likeDTOList == null || !isClicked) {  // 조건을 합침.
                likeService.save(boardId, loginEmail);
                boardService.upLikeHits(boardId);
                response.put("isClicked", true);
            } else {
                boardService.downLikeHits(boardId);
                response.put("isClicked", false);
            }

            Long likeCount = boardService.getLikeHits(boardId);
            response.put("success", true);
            response.put("likeCount", likeCount);

            System.out.println("like method called with boardId: " + boardId + ", isClicked: " + isClicked);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "Internal Server Error");
        }
        return response;
    }

}
