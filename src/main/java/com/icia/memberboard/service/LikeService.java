package com.icia.memberboard.service;

import com.icia.memberboard.dto.LikeDTO;
import com.icia.memberboard.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public void save(Long boardId, String loginEmail) {
        likeRepository.save(boardId, loginEmail);
    }
    public void update(Long boardId, boolean isClicked) {
        likeRepository.update(boardId, isClicked);
    }

    public List<LikeDTO> findById(Long boardId, String loginEmail) {
        return likeRepository.findById(boardId, loginEmail);
    }

}
