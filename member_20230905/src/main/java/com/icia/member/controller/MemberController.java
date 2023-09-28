package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String update(HttpSession session, Model model) {
        // 필요한 정보를 모델에 담아서 전달
        // 여기서는, 현재 로그인한 회원의 정보를 가져와서 수정 페이지에 표시할 수 있다.
        String memberEmail = (String) session.getAttribute("loginEmail");
        MemberDTO memberDTO = memberService.findByMemberEmail(memberEmail);// email에 해당하는 회원 정보 조회
        System.out.println(memberDTO);

        model.addAttribute("member", memberDTO); // 모델에 회원 정보를 담아서 뷰로 전달
        return "memberUpdate";
    }

    @PostMapping("/memberUpdate")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        int rowsUpdated = memberService.update(memberDTO);

        if (rowsUpdated > 0) {
            return "memberMain"; // 업데이트 성공 시 memberMain 페이지로 이동
        } else {
            return "memberUpdate"; // 업데이트 실패 시 다시 memberUpdate 페이지로 이동
        }
    }
    @PostMapping(value = "/check-email")
    public @ResponseBody String ajaxCheckEmail(@RequestParam("memberEmail") String memberEmail ) {
        String isEqualEmails = memberService.checkEmail(memberEmail);
            return isEqualEmails;
    }
    @PostMapping (value = "/detail-member-by-email")
        public @ResponseBody MemberDTO ajaxGetMemberByEmail(@RequestParam("memberEmail") String memberEmail) {
            MemberDTO dbMember = memberService.findByMemberEmail(memberEmail);
            if(dbMember != null){
                return dbMember;
            }else{
                return null;

            }

    }


}