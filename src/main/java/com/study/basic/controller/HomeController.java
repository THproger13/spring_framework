package com.study.basic.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "welcome";
    }

    //req1 요청을 처리하는 메서드
    //@GetMapping("/req1")
    //req1 요청을 처리하는 메서드이지만 좀더 포괄적인 개념 - method를 무조건 지정

    @RequestMapping(method = RequestMethod.GET, value = "/req1")
    public String req1() {
        System.out.println("HomeController.req1");
        return "req1";
    }

    @GetMapping("/req2")
    //파라미터 이름과 변수이름 동일하면 파라미터이름을 생략가능
    public String req2(@RequestParam("q1") String q1, @RequestParam("q2") int q2){
        System.out.println("q1 = " + q1 + ", q2 = " + q2);
        return "welcome";

    }
    @GetMapping("/req3")
    public String req3(@RequestParam("p1") String p1, @RequestParam("p2") String p2) {
        System.out.println("p1 = " + p1 + ", p2 = " + p2);
        return "welcome";
    }
}
