package com.icia.board.service;

import com.icia.board.dto.CommentDTO;
import com.icia.board.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    public void save(Long boardId) {
        commentRepository.save(boardId);
    }

    public List<CommentDTO> findAllByBoardId(Long boardId) {
//        System.out.println("서비스의 commentDTOList" + );
        return commentRepository.findAllByBoardId(boardId);

    }
}
