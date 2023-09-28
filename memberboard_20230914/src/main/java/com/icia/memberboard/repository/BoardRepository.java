package com.icia.memberboard.repository;

import com.icia.memberboard.dto.BoardDTO;
import com.icia.memberboard.dto.BoardFileDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public BoardDTO save(BoardDTO boardDTO) {
        sql.insert("Board.save", boardDTO);
        return boardDTO;
    }

    public void saveFile(BoardFileDTO boardFileDTO) {
        sql.insert("Board.saveFile", boardFileDTO);
    }

    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }

    public List<BoardDTO> pagingList(Map<String, Integer> pageParams) {
        return sql.selectList("Board.pagingList", pageParams);
    }
    public int boardCount() {
        return sql.selectOne("Board.count");
    }

    public List<BoardDTO> searchList(Map<String, Object> searchParam) {
        return sql.selectList("Board.search", searchParam);
    }

    public int boardSearchCount(Map<String, String> pagingParams) {
        return sql.selectOne("Board.searchCount", pagingParams);
    }
    public void upHits(Long boardId) {
        sql.update("Board.upHits", boardId);
    }

    public BoardDTO findById(Long boardId) {
        return sql.selectOne("Board.findById", boardId);
    }
    public List<BoardFileDTO> findFile(Long boardId) {
        return sql.selectList("Board.findFile", boardId);
    }

    public void delete(Long boardId) {
        sql.delete("Board.delete", boardId);
    }
    public void deleteFile(BoardFileDTO boardFileDTO) {
        sql.delete("Board.deleteBoardFile",boardFileDTO);
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }

    public void upLikeHits(Long boardId) {
        sql.update("Board.upLikeHits", boardId);
    }

    public void downLikeHits(Long boardId) {
        sql.update("Board.downLikeHits", boardId);
    }

    public Long getLikeHits(Long boardId) {
        return sql.selectOne("Board.getLikeHits", boardId);
    }


}
