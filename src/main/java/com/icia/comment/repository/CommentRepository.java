package com.icia.comment.repository;

import com.icia.comment.dto.CommentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int save(Long boardId) {
        return sql.insert("Comment.save", boardId);
    }

}
