package com.icia.memberboard.controller;

import com.icia.memberboard.dto.MemberDTO;
import com.icia.memberboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/member")
public class MemberController {
@Autowired
    private MemberService memberService;

@GetMapping("/save")
public String save() {
    return "/memberPages/save";
}

@PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) throws IOException {
    try {
        memberService.save(memberDTO);
    }catch (Exception e) {
        e.printStackTrace();
    }
    return "index";
}

}
