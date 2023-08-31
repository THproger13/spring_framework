package com.ex.demo.dto;
//lombok
import lombok.Getter;
import lombok.Setter;

import lombok.ToString;
//롬복의 getter, setter, tostring 어노테이션을 사용하면 따로 getter, setter를 만들 밀요가 없다.
//따라서 재사용성이 매우 높아진다.
@Setter
@Getter
@ToString
public class DemoDTO {

    private String param1;

    private String Param2;

//    public void setParam1(String param1) {
//        this.param1 = param1;
//    }
//
//    public void setParam2(String param2) {
//        this.Param2 = param2;
//    }
//
//    @Override //Override Annotation
//    public String toString() {
//        return "DemoDTO{" +
//                "param1='" + param1 + '\'' +
//                ", Param2='" + Param2 + '\'' +
//                '}';
//    }
}
