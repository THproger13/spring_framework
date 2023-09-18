package com.icia.memberboard.repository;

import com.icia.memberboard.dto.LikeDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public void save(LikeDTO likeDTO) {
        sql.insert("Like.save", likeDTO);
    }

    public void upLike(Long boardId) {
        sql.update("Like.upLike", boardId);
    }
    public void downLike(Long boardId) {
        sql.update("Like.downLike", boardId);
    }
    public LikeDTO findById(Long boardId) {
        return sql.selectOne("Like.findById", boardId);
    }


}
