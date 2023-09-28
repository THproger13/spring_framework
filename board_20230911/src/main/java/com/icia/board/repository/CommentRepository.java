package com.icia.board.repository;

import com.icia.board.dto.CommentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public void save(Long boardId) {
        sql.insert("Comment.save", boardId);
    }

    public List<CommentDTO> findAllByBoardId(Long boardId) {
        List<CommentDTO> commentList = sql.selectList("Comment.findAllByBoardId", boardId);
        System.out.println("레포지토리의 commentList" + commentList);
        return commentList;
    }
}
