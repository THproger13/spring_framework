package com.icia.memberboard.dto;

import lombok.Data;

@Data
public class LikeDTO {

    private Long likeId;
    private Long boardId;
    private String loginEmail;
    private Long likeCount;
    private boolean isClicked;

}
