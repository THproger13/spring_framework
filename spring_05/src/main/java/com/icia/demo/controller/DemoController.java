package com.icia.demo.controller;

import com.icia.demo.dto.DemoDTO;
import com.icia.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DemoController {
    // StudyService 객체 주입
    @Autowired
    private DemoService demoService;

    @GetMapping("/demo1")
    public String demo1() {
        return "/demo1";
    }

    @GetMapping("/demo2")
    public String demo2() {
        return "/demo2";
    }

    @GetMapping("/req1")
    public String req1(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
       DemoDTO demoDTO = demoService.req1(name, age);
        model.addAttribute("demo", demoDTO);
        return "req1";
    }

    @PostMapping("/req2")
    public String req2(@ModelAttribute DemoDTO demoDTO, Model model) {
        System.out.println("demoDTO = " + demoDTO + ", model = " + model);
        List<DemoDTO> demoListDTO = demoService.req2(demoDTO);
        model.addAttribute("demoList", demoListDTO);
        return "req2";
    }
//
//    @PostMapping("/req3")
//    public String req3(@ModelAttribute StudyDTO studyDTO) {
//        studyService.req3(studyDTO);
//        return "index";
//    }
//
//    @GetMapping("/req4")
//    public String req4(Model model) {
//        // studyService 클래스의 req4 메서드를 호출하고 호출 결과를
//        // StudyDTO 클래스타입의 studyDTO 객체에 담는다.
//        StudyDTO studyDTO = studyService.req4();
//        // 가져갈 데이터 담는다.
//        model.addAttribute("study", studyDTO);
//        // 목적지를 정한다.
//        return "req4";
//    }



}