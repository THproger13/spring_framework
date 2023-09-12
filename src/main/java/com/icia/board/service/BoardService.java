package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
    }
    public List<BoardDTO> list() {
        List<BoardDTO> dbBoardList = boardRepository.list();
        if (dbBoardList != null) {
            return dbBoardList;
        }
        return null;
    }

    public BoardDTO findById(Long id) {
        BoardDTO dbBoardDetail = boardRepository.findById(id);
        if(dbBoardDetail != null) {
            return dbBoardDetail;
        }
        return null;
    }
    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }
    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }
}
