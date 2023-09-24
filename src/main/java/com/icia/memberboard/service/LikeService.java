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

    public List<LikeDTO> findByIdAndEmail(Long boardId, String loginEmail) {
        return likeRepository.findByIdAndEmail(boardId, loginEmail);
    }

    public boolean getIsLiked(Long boardId, String loginEmail) {
        return likeRepository.getIsLiked(boardId, loginEmail);
    }

    public boolean toggleIsLiked(Long boardId, String loginEmail) {
        if(findByIdAndEmail(boardId, loginEmail) != null) {
            likeRepository.delete(boardId, loginEmail);
            return true;
        }else{
            likeRepository.save(boardId, loginEmail);
            return false;
        }
    }
}
