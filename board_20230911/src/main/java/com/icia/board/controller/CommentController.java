package com.icia.board.controller;

import com.icia.board.dto.CommentDTO;
import com.icia.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping (value="/save")
    public @ResponseBody List<CommentDTO> save(@RequestBody CommentDTO commentDTO, @RequestParam Long boardId) {
        commentService.save(boardId);
        List<CommentDTO> commentDTOList = commentService.findAllByBoardId(boardId);
        if (commentDTOList != null) {
            System.out.println( "컨트롤러의 commentDTOList" +  commentDTOList);
            return commentDTOList;
        } else {
            return null; // 댓글이 없는 경우 빈 리스트 반환
        }

    }
}
