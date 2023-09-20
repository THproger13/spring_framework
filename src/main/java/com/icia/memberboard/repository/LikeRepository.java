package com.icia.memberboard.repository;

import com.icia.memberboard.dto.LikeDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LikeRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public void save(Long boardId, String loginEmail) {
        Map<String, Object> params = new HashMap<>();
        params.put("boardId", boardId);
        params.put("loginEmail", loginEmail);
        sql.insert("Like.save", params);
    }


    public void update(Long boardId, boolean isClicked) {
        sql.update("Like.update", isClicked);
    }
    public List<LikeDTO> findById(Long boardId, String loginEmail) {
        Map<String, Object> params = new HashMap<>();
        params.put("boardId", boardId);
        params.put("loginEmail", loginEmail);
        return sql.selectList("Like.findById", params);
    }
}
