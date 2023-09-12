package com.icia.comment.service;

import com.icia.comment.dto.CommentDTO;
import com.icia.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    public CommentDTO save(Long boardId) {
        CommentDTO commentDTO = commentRepository.save(boardId);
        return commentDTO;
    }
}
