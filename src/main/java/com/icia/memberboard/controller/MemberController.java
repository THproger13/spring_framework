package com.icia.memberboard.controller;

import com.icia.memberboard.dto.MemberDTO;
import com.icia.memberboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/login")
    public String loginForm() {
        return "/memberPages/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        boolean loginResult = memberService.login(memberDTO);
        if (loginResult) {
            // 로그인 성공시 사용자의 이메일을 세션에 저장
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            // model.addAttribute("member", memberDTO); // x
            // 모델에 이메일 저장
            model.addAttribute("email", memberDTO.getMemberEmail());
            return "index";
        } else {
            return "/boardPages/list";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 아래 방법 중 한가지만 사용
        // 해당 파라미터만 없앨 경우
        session.removeAttribute("loginEmail");
        // 세션 전체를 없앨 경우
//        session.invalidate();
        return "redirect:/";
    }
}
