package com.icia.study.controller;

import com.icia.study.dto.StudyDTO;
import com.icia.study.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudyController {
    // StudyService 객체 주입
    @Autowired
    private StudyService studyService;

    @GetMapping("/req1")
    public String req1() {
        // StudyService 클래스의 req1 메서드 호출
        studyService.req1();
        return "index";
    }

    @GetMapping("/req2")
    public String req2(@RequestParam("p1") String p1, @RequestParam("p2") String p2) {
        studyService.req2(p1, p2);
        return "index";
    }

    @PostMapping("/req3")
    public String req3(@ModelAttribute StudyDTO studyDTO) {
        studyService.req3(studyDTO);
        return "index";
    }

    @GetMapping("/req4")
    public String req4(Model model) {
        // studyService 클래스의 req4 메서드를 호출하고 호출 결과를
        // StudyDTO 클래스타입의 studyDTO 객체에 담는다.
        StudyDTO studyDTO = studyService.req4();
        // 가져갈 데이터 담는다.
        model.addAttribute("study", studyDTO);
        // 목적지를 정한다.
        return "req4";
    }

    @GetMapping("/req5")
    public String req5(Model model) {
        List<StudyDTO> studyDTOList = studyService.req5();
        // 가져갈 데이터 담는다.
        model.addAttribute("studyList", studyDTOList);
        // 목적지를 정한다.
        return "req5";
    }

}