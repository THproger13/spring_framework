package com.icia.comment.controller;

import com.icia.comment.dto.CommentDTO;
import com.icia.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping (value="/comment/save")
    public @ResponseBody List<CommentDTO> save(@RequestBody CommentDTO commentDTO, @RequestParam Long boardId) {
        CommentDTO savedComment = commentService.save(commentDTO, boardId);
        if (savedComment != null) {
            return commentService.findAllByBoardId(boardId);
        } else {
            return new ArrayList<>(); // 댓글이 없는 경우 빈 리스트 반환
        }

    }
}
