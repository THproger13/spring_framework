package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/memberSave")
    public String save(){
        return "memberSave";
    }

    @PostMapping("/memberSave")
    public String save(@ModelAttribute MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "index";

    }
    @GetMapping("/memberList")
    public String list(Model model){
        List<MemberDTO> memberDTOList = memberService.list();
        model.addAttribute("memberDTOList", memberDTOList); // => 화면에 가져갈 데이터
        return "memberList";

    }


}
