package com.icia.memberboard.controller;

import com.icia.memberboard.dto.LikeDTO;
import com.icia.memberboard.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/like")
    @ResponseBody
    public Map<String, Object> like(@RequestParam Long boardId,@RequestBody LikeDTO likeDTO) {
        Map<String, Object> response = new HashMap<>();

        // 사용자가 이미 좋아요 버튼을 클릭했는지 확인합니다 (이를 위해 세션 또는 사용자 인증이 필요할 수 있습니다)
        boolean isClicked = false;// 여기에 사용자가 이미 이 게시물에 좋아요를 클릭했는지 확인하는 로직을 구현합니다.
        likeDTO = likeService.findById(boardId);

        if (!isClicked && likeDTO.getLikeCount()==0) {
            // 데이터베이스에서 좋아요 수를 증가시킵니다.
            if (likeDTO != null) {
                likeDTO.setLikeCount(likeDTO.getLikeCount() + 1);
                likeService.save(likeDTO);

                // 업데이트된 좋아요 수를 포함한 응답을 보냅니다.
                response.put("success", true);
                response.put("likeCount", likeDTO.getLikeCount());
            } else {
                response.put("success", false);
                response.put("message", "게시물을 찾을 수 없습니다.");
            }
        } else if(!isClicked && likeDTO.getLikeCount() > 0) {
//            LikeDTO likeDTO = likeService.findById(boardId);
            if (likeDTO != null) {
                likeDTO.setLikeCount(likeDTO.getLikeCount() + 1);
                likeService.upLike(boardId);

                // 업데이트된 좋아요 수를 포함한 응답을 보냅니다.
                response.put("success", true);
                response.put("likeCount", likeDTO.getLikeCount());
            } else {
                response.put("success", false);
                response.put("message", "게시물을 찾을 수 없습니다.");
            }
            response.put("success", false);
            response.put("message", "이미 이 게시물에 좋아요를 클릭하셨습니다.");
        }else if(isClicked && likeDTO.getLikeCount() == 0) {

//            LikeDTO likeDTO = likeService.findById(boardId);
            if (likeDTO != null) {
                likeDTO.setLikeCount(likeDTO.getLikeCount() - 1);
                likeService.downLike(boardId);

                // 업데이트된 좋아요 수를 포함한 응답을 보냅니다.
                response.put("success", true);
                response.put("likeCount", likeDTO.getLikeCount());
            } else {
                response.put("success", false);
                response.put("message", "게시물을 찾을 수 없습니다.");
            }
            response.put("success", false);
            response.put("message", "이미 이 게시물에 좋아요를 클릭하셨습니다.");
        }

        return response;
    }

}
