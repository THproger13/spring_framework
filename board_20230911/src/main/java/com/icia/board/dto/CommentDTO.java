package com.icia.board.dto;

import lombok.Data;

import java.security.Timestamp;

@Data
public class CommentDTO {
    private Long cid;
    private String commentWriter;
    private String commentContents;
    private Long boardId;
    private Timestamp commentCreatedDate;
}
