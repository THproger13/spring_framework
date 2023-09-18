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

    public LikeDTO findById(Long boardId) {
        return likeRepository.findById(boardId);
    }

}
