package com.icia.memberboard.controller;

import com.icia.memberboard.dto.LikeDTO;
import com.icia.memberboard.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Like")
public class LikeController {
    @Autowired
    private LikeService likeService;

   @PostMapping("/save")
    public ResponseEntity LikeSave(@ModelAttribute LikeDTO likeDTO,
                                   @RequestParam("boardId") Long boardId) {
      likeService.save(likeDTO);
      LikeDTO likeDBDTO = likeService.findById(boardId);
      return new ResponseEntity<>(likeDBDTO, HttpStatus.OK);
   }

}
