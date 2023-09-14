package com.icia.memberboard.controller;

import com.icia.memberboard.dto.MemberDTO;
import com.icia.memberboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        e.getCause();
        e.printStackTrace();
        System.out.println("e = " + e);

    }
    return "index";
}

@PostMapping("/check-email-dup")
    public ResponseEntity duplicateCheck(@RequestParam("memberEmail") String memberEmail) {
    MemberDTO memberDTO = memberService.findByMemberEmail(memberEmail);
    if(memberDTO == null) {
        return new ResponseEntity<>(HttpStatus.OK);
    }else {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}

}
