package com.icia.memberboard.controller;

import com.icia.memberboard.dto.MemberDTO;
import com.icia.memberboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/list")
    public String list(Model model) {
    try {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberDTOList", memberDTOList);
        return "/memberPages/list";
    }catch(Exception e) {
        e.getCause();
        e.printStackTrace();
        System.out.println("e = " + e);
    }
    return "/memberPages/list";

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
        try {
            if (loginResult) {
                // 로그인 성공시 사용자의 이메일을 세션에 저장
                session.setAttribute("loginEmail", memberDTO.getMemberEmail());
                // model.addAttribute("member", memberDTO);
                // 모델에 이메일 저장
                model.addAttribute("email", memberDTO.getMemberEmail());
                return "index";
            } else {
                return "/boardPages/list";
            }
        }catch(Exception e) {
                e.getCause();
                e.printStackTrace();
                System.out.println("e = " + e);
        }
        return "/boardPages/list";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        try {
            // 아래 방법 중 한가지만 사용
            // 해당 파라미터만 없앨 경우
            session.removeAttribute("loginEmail");
            // 세션 전체를 없앨 경우
    //        session.invalidate();
        }catch (Exception e) {
            return "redirect:/";
        }
            return "redirect:/";
    }

    @GetMapping("/sample")
    public String sampleData() {
    try {
        for (int i = 1; i <= 20; i++) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setMemberEmail("aa" + i + "@naver.com");
            memberDTO.setMemberPassword("pass" + i + "#");
            memberDTO.setMemberName("memberName" + i);
            memberDTO.setMemberMobile("010-" + i + i + i + i + "-" + i + i + i + i);

            memberService.sampleData(memberDTO);
        }
    }catch (Exception e) {
        e.getCause();
        e.printStackTrace();
        System.out.println("e = " + e);
    }
        return "redirect:/memberPages/list";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("memberId") Long memberId) {
    MemberDTO memberDTO = memberService.findById(memberId);
    if(memberDTO.getMemberProfileAttached() == 1){
        memberService.deleteMemberProfile(memberId);
    }
    memberService.delete(memberId);
        return "redirect:/memberPages/list";
    }

    @GetMapping("/update")
    public String update(HttpSession session, Model model) {
    try {
        String email = (String) session.getAttribute("loginEmail");
        MemberDTO memberDTO = memberService.findByMemberEmail(email);
        model.addAttribute("member", memberDTO);
    }catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error occurred: " + e.getMessage());
    }
    return "/memberPages/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return "index";
    }

}
