package com.icia.memberboard.controller;

import com.icia.memberboard.dto.CommentDTO;
import com.icia.memberboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/saveAjax")
        public ResponseEntity commentSave(@ModelAttribute CommentDTO commentDTO) {
            commentService.save(commentDTO);
            List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
            return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("commentId") Long commentId) {
        commentService.delete(commentId);
        return "redirect:/board/detail";
    }
}
