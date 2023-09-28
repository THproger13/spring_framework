package com.ex.demo.controller;


import com.ex.demo.dto.DemoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    //req1 요청을 처리하는 메서드
    //@GetMapping("/req1")
    //req1 요청을 처리하는 메서드이지만 좀더 포괄적인 개념 - method를 무조건 지정

    @RequestMapping(method = RequestMethod.GET, value = "/demo1")
    public String demo1() {
        System.out.println("HomeController.demo1");
        return "demo1";
    }

    @PostMapping("/demo2")
    //파라미터 이름과 변수이름 동일하면 파라미터이름을 생략가능
    public String req2(@RequestParam("param1") String param1, @RequestParam("param2") String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        DemoDTO demoDTO = new DemoDTO();

        return "index";

    }
    @PostMapping("/demo3")
    public String demo3(@ModelAttribute DemoDTO demoDTO){
        System.out.println("demoDTO = " + demoDTO);
        return "index";
    }

}