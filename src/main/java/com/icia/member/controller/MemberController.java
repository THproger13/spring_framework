package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
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
    @GetMapping("/memberLogin")
    public String login(){
        return "memberLogin";
    }
    @PostMapping("/memberLogin")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        if (memberService.login(memberDTO)) {
            // 로그인 성공시 사용자의 이메일을 세션에 저장
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            //모델에 이메일 저장
            model.addAttribute("email", memberDTO.getMemberEmail());
            return "memberMain"; // 로그인 성공
        } else {
            return "memberLogin"; // 로그인 실패
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 해당 파라미터만 없앨 경우
        session.removeAttribute("loginEmail");
        //세션 전체를 없앨 경우
        //session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/memberUpdate")
    public String update(){
      return "memberUpdate";

    }

    @PostMapping("/memberUpdate")
    public String update(@ModelAttribute MemberDTO memberDTO){
        memberService.update(memberDTO);
        return "memberUpdate";

    }

}