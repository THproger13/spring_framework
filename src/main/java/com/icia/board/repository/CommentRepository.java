package com.icia.board.repository;

import com.icia.board.dto.CommentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int save(CommentDTO commentDTO, Long boardId) {
        return sql.insert("Comment.save", boardId);
    }

}
