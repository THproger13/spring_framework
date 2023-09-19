package com.icia.memberboard.controller;

import com.icia.memberboard.dto.LikeDTO;
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

    @PostMapping("/like")
    @ResponseBody
    public Map<String, Object> like(@RequestParam Long boardId, HttpSession session) {
        Map<String, Object> response = null;
        try {
            response = new HashMap<>();
            String loginEmail = (String) session.getAttribute("loginEmail");

            // DB에서 현재 loginEmail과 boardId에 해당하는 레코드를 찾음.
            Long likeCount = likeService.findById(boardId);
            boolean isClicked = likeCount != null && likeCount > 0;

//        LikeDTO likeDTO = new LikeDTO();

            if (likeCount == null ) {
                // 좋아요를 처음 누르는 경우
                likeService.save(boardId, true); // DB에 추가
                likeService.upLike(boardId); // likeCount 증가
                System.out.println(likeCount);
                response.put("success", true);
                response.put("likeCount", likeService.findById(boardId));
                response.put("isClicked", true);
            } else if (isClicked) {
                // 이미 좋아요를 눌렀던 경우
                likeService.update(boardId, false); // isClicked를 false로 설정
                likeService.downLike(boardId); // likeCount 감소
                System.out.println(likeCount);
                response.put("success", true);
                response.put("likeCount", likeService.findById(boardId));
                response.put("isClicked", false);
            } else {
                // 좋아요를 취소했다가 다시 누르는 경우
                likeService.update(boardId, true);
                // isClicked를 true로 설정
                likeService.upLike(boardId); // likeCount 증가
                System.out.println(likeCount);
                response.put("success", true);
                response.put("likeCount", likeService.findById(boardId));
                response.put("isClicked", true);
            }
            return response;

        } catch (Exception e) {
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }

        return response;
    }

}
