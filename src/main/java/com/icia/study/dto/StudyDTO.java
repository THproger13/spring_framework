package com.icia.study.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Data//getter, setter, tostring어노테이션을 한번에 합친것

public class StudyDTO {
    private String p1;
    private String p2;
    private int p3;


}
