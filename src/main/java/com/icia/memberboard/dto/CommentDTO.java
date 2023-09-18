package com.icia.memberboard.dto;

import lombok.Data;

@Data
public class CommentDTO {

    private Long commentId;
    private String commentWriter;
    private String commentContents;
    private Long boardId;
    private String commentCreatedDate;

}
