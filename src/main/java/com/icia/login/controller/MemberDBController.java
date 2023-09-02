package com.icia.login.controller;

import com.icia.login.dto.MemberDTO;
import com.icia.login.service.MemberDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberDBController {
    @Autowired
    private MemberDBService memberDBService;

    @GetMapping("/Memberdb")
    public String Memberdb() {
        return "Memberdb";
    }

    @PostMapping("/reqdb1")
    public String reqdb1(@ModelAttribute MemberDTO memberDTO) {
        demoDBService.reqdb1(memberDTO);
        return "index";
    }

    @GetMapping("Memberdbidrow")
    public String Memberdbidrow(){
        return "Memberdbidrow";
    }

    @GetMapping("/demodb2")
    public String demodb2(Model model) {
        List<DemoDTO> demoDTOList = demoDBService.findAll();
        System.out.println("demoDTOList = " + demoDTOList);
        model.addAttribute("demoList", demoDTOList);
        return "demodb2";
    }

    @GetMapping("/find")
    public String findById(@RequestParam("id") Long id, Model model) {
        DemoDTO demoDTO = demoDBService.findById(id);
        model.addAttribute("demo", demoDTO);
        return "demodb3";
    }
}