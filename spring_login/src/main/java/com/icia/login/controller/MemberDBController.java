package com.icia.login.controller;

import com.icia.login.dto.MemberDTO;
import com.icia.login.service.MemberDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberDBController {
    @Autowired
    private MemberDBService memberDBService;

    @GetMapping("/memberdb")
    public String memberdb() {
        return "memberdb";
    }

    @PostMapping("/reqdb1")
    public String reqdb1(@ModelAttribute MemberDTO memberDTO) {
        try {
            memberDBService.reqdb1(memberDTO);
        } catch (Exception e) {
            e.printStackTrace(); // 에러 스택 트레이스 출력
        }
        return "index";
    }

    @GetMapping("/memberdblist")
    public String memberdblist(Model model) {
        List<MemberDTO> memberDTOList = memberDBService.findAll();
        System.out.println("memberDTOList = " + memberDTOList);
        model.addAttribute("memberDTOList", memberDTOList);
        return "memberdblist";
    }
    @GetMapping("/find")

    public String findById(@RequestParam("id") Long id, Model model) {
        MemberDTO memberDTO = memberDBService.findById(id);
        System.out.println("member = " + memberDTO);
        model.addAttribute("member", memberDTO);
        return "memberdbidrow";
    }
}
