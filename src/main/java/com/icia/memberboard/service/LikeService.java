package com.icia.memberboard.service;

import com.icia.memberboard.dto.LikeDTO;
import com.icia.memberboard.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public void save(Long boardId, boolean isClicked) {
        likeRepository.save(boardId, isClicked);
    }
    public void update(Long boardId, boolean isClicked) {
        likeRepository.update(boardId, isClicked);
    }

    public void upLike(Long boardId) {
        likeRepository.upLike(boardId);
    }
    public void downLike(Long boardId) {
        likeRepository.downLike(boardId);
    }
    public Long findById(Long boardId) {
        return likeRepository.findById(boardId);
    }

}
