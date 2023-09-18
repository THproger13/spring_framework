package com.icia.memberboard.service;

import com.icia.memberboard.dto.LikeDTO;
import com.icia.memberboard.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public void save(LikeDTO likeDTO) {
        likeRepository.save(likeDTO);
    }

    public void upLike(Long boardId) {
        likeRepository.upLike(boardId);
    }
    public void downLike(Long boardId) {
        likeRepository.downLike(boardId);
    }
    public LikeDTO findById(Long boardId) {
        return likeRepository.findById(boardId);
    }

}
