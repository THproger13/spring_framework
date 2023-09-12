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
    public List<CommentDTO> findById(Long boardId) {
        List<CommentDTO> dbCommentList = commentRepository.findById(boardId);
        return dbCommentList;
    }
}
