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

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudyController {
    @Autowired
    private StudyService studyService;
    @GetMapping("/req1")
    public String req1() {
        // StudyService 클래스의 req1 메서드 호출
        studyService.req1();
        return "index";

    }
    @GetMapping("/req2")
    //파라미터 이름과 변수이름 동일하면 파라미터이름을 생략가능
    public String req2(@RequestParam("p1") String p1, @RequestParam("p2") String p2, @RequestParam("p3") int p3){
        studyService.req2(p1, p2, p3);
        StudyDTO studyDTO = new StudyDTO();
        return "index";

    }
    @PostMapping("/req3")
    public String demo3(@ModelAttribute StudyDTO studyDTO){
        studyService.req3(studyDTO);
        System.out.println("studyDTO = " + studyDTO);
        return "index";

    }

    @GetMapping("/req4")
    public String req4(Model model){

    StudyDTO studyDTO = studyService.req4();
     //가져갈 데이터 담는다.
        model.addAttribute("study", studyDTO);
        //목적지를 정한다.
        return "req4";
    }

    @GetMapping("/req5")
    public String req5(Model model){
        List<StudyDTO> studyDTOList = studyService.req5();

        model.addAttribute("studyList", studyDTOList);
        return "req5";
    }


}
