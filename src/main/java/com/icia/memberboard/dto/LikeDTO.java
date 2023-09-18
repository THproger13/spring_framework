package com.icia.memberboard.dto;

import lombok.Data;

@Data
public class LikeDTO {

    private Long boardId;
    private Long likeCount;
    private boolean isClicked;

}
