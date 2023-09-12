package com.icia.board.dto;

import lombok.Data;

import java.util.Date;
@Data
public class BoardDTO {
    //DTO에서 string으로 날짜 데이터를 하지 않고 자바의 localdate등을 사용하면 db의 날짜
    //데이터 형식에 따라 출력이 이상하게 되는경우가 있다.

    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private String createdAt;
    private int boardHits;
    private int fileAttached;

}
