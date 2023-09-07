package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AjaxController {

    @GetMapping("/ajax01")
        public String ajax01() {
            return "index";
        }
    @GetMapping("/ajax02")
    public String ajax02() {
        return "index";//ajax를 사용할떄는  이렇게 해도 페이지 이동이 안된다.
        // ajax.jsp파일에서 location으로 이동하기
        //따라서 여기서 index를 리턴하는게 의미가 없다.
    }
    //여기서 리턴 값이 jsp파일의 res매개변수로 전달,
    //value="/ajax03", produces = "application/text; charset=utf-8"
    //이부분은 브라우저 콘솔의 출력을 한글로 안깨지도록 한다.
    @GetMapping(value="/ajax03", produces = "application/text; charset=utf-8")  //ResponseBody는 http통신의 body에 값을 실어준단 의미
    public @ResponseBody String ajax03() {
//        String returnValue = "리턴 값입니다. ";
//        return returnValue;
        return "리턴 값입니다.";
    }
    @GetMapping("/ajax04")
    public @ResponseBody String ajax04(@RequestParam("p1") String p1, @RequestParam("p2") String p2) {
        System.out.println("p1 = " + p1 + ", p2 = " + p2);
        return "ok";
    }

    @PostMapping("/ajax05")
    public @ResponseBody String ajax05(@RequestParam("p1") String p1, @RequestParam("p2") String p2){
        System.out.println("p1 = " + p1 + ", p2 = " + p2);
        return "good";
    }
    @PostMapping("/ajax06")
    public @ResponseBody String ajax06(@ModelAttribute MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        return "great";
    }
    @Autowired
    private MemberService memberService;

    @GetMapping(value="/ajax07")  //ResponseBody는 http통신의 body에 값을 실어준단 의미
    public @ResponseBody MemberDTO ajax07() {
        MemberDTO memberDTO = memberService.getMemberById(1L);

        return memberDTO;
    }
    @GetMapping(value="/ajax08")  //ResponseBody는 http통신의 body에 값을 실어준단 의미
    public @ResponseBody List<MemberDTO> ajax08() {
       List<MemberDTO> memberDTOList = memberService.list();

        return memberDTOList;
    }
    @PostMapping("/ajax09") //JSON데이터로 요청이 오는 경우 @RequestBody 어노테이션 사용
    public @ResponseBody MemberDTO ajax09(@RequestBody MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        return memberDTO;
    }
    @PostMapping("/ajax10")
    public @ResponseBody List<MemberDTO> ajax10(@ModelAttribute MemberDTO memberDTO){
        memberService.save(memberDTO);
        List<MemberDTO> memberDTOList = memberService.list();
        return memberDTOList;
    }
    @PostMapping(value = "/ajax11", produces = "application/text; charset=utf-8")
    //ResponseEntity의 경우 데이터와 응답 코드를 같이 가지는 클래스다.
    public ResponseEntity ajax11(@ModelAttribute MemberDTO memberDTO){
        try{
            memberService.save(memberDTO);
        }catch (Exception e){
            // 이메일이 중복되는 상황에서 Conflict라는 응답코드를 줌
            return new ResponseEntity<>(" 이메일이 중복되었습니다!", HttpStatus.CONFLICT);
        }
        List<MemberDTO> memberDTOList = memberService.list();
        //문제가 없다면 회원 리스트 데이터와 200 코드를 응답으로 줌
        return new ResponseEntity<>(memberDTOList, HttpStatus.OK);
    }


    }

