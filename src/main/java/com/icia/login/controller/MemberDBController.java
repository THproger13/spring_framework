package com.icia.login.controller;

import com.icia.login.dto.MemberDTO;
import com.icia.login.service.MemberDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        memberDBService.reqdb1(memberDTO);
        return "index";
    }



//    @GetMapping("/find")
//    public String findById(@RequestParam("id") Long id, Model model) {
//        DemoDTO demoDTO = demoDBService.findById(id);
//        model.addAttribute("demo", demoDTO);
//        return "demodb3";
//    }
}