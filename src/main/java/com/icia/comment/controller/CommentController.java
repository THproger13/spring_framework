package com.icia.comment.controller;

import com.icia.comment.dto.CommentDTO;
import com.icia.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

//    @GetMapping("/save")
//    public String save(@RequestParam Long boardId, Model model) {
//        List<CommentDTO> commentDTOList = commentService.findById(boardId);
//        model.addAttribute("commentDTOList", commentDTOList);
//        return "commentPages/commentSave";
//    }

    @PostMapping (value="/save")
    public @ResponseBody List<CommentDTO> save(@ModelAttribute List<CommentDTO> commentDTOList, @RequestParam Long boardId) {
        List<CommentDTO> commentList = commentService.findById(boardId);
        if(commentList != null) {
            return commentList;
        }else{
            return null;
        }

    }
}
