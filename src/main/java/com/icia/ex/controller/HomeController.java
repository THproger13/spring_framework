package com.icia.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //"@" 사용하는 형식을 annotation이라고 한다. 오버로딩이나 오버라이딩을 할때도 사용- 해당 클래스를 컨트롤러로 사용할거라고 지정을 해준다.

public class HomeController {
    //프로젝트 실행시 기본주소(/) 요청 메서드 선언
    //프로젝트 시작하면 index.jsp를 브라우저에 출력
    @GetMapping("/")
    public String index(){
        return "index"; //index.jsp를 띄운다는 의미
    }
}
