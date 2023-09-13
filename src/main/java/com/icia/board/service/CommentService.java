package com.icia.board.service;

import com.icia.board.dto.CommentDTO;
import com.icia.board.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    public CommentDTO save(CommentDTO commentDTO , Long boardId) {
        int dbcommentDTO = commentRepository.save(commentDTO, boardId);
        return dbcommentDTO;
    }
}
