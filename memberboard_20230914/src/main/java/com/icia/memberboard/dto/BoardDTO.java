package com.icia.memberboard.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardDTO extends MemberDTO {

    private Long boardId;
    private String boardTitle;
    private Long boardWriterId;
    private String boardWriter;
    private String boardContents;
    private int boardHits;
    private Long LikeHits;
    private String createdAt;
    private int fileAttached;
    private List<MultipartFile> boardFile;

}
