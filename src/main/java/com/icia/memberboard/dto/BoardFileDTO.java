package com.icia.memberboard.dto;

import lombok.Data;

@Data
public class BoardFileDTO extends BoardDTO {

    private Long BoardFileId;
    private String originalFileName;
    private String storedFileName;

}
