package com.icia.study.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.UtilityClass;

@Data//getter, setter, tostring어노테이션을 한번에 합친것
@Getter
@Setter
@ToString

public class StudyDTO {

    private String p1;
    private String p2;
    private int p3;

}
