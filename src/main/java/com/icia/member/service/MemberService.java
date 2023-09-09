package com.icia.member.service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;


    public void save(MemberDTO memberDTO) {
        memberRepository.save(memberDTO);
    }

    public int update(MemberDTO memberDTO) {
        // MemberRepository를 사용하여 DB에서 회원 정보를 업데이트합니다.
        // sql문의 insert문을 repository내부에서 수행할때의 return값은
        // 수행에 문제가 있을 때는 '0'을 반환하고명령 수행 성공시엔 return값이 0보다 크다.
        // 따라서 service 클래스 내에서 try-catch문을 사용하여 update성공, 실패 경우의 수를
        // 나누었다.
        // 업데이트가 성공하면 영향을 받은 행(row)의 수를 반환하고, 실패하면 0을 반환합니다.

        try {
            int rowsUpdated = memberRepository.update(memberDTO);
            return rowsUpdated;
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // 업데이트 실패 시 0을 반환
        }
    }

    public List<MemberDTO> list() {
        System.out.println(memberRepository.list());
        return memberRepository.list();
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO dbMember = memberRepository.findMemberByEmail(memberDTO.getMemberEmail());

        if (dbMember != null && dbMember.getMemberPassword().equals(memberDTO.getMemberPassword())) {
            return true; // 로그인 정보 일치
        }
        return false; // 로그인 정보 불일치
    }


    public MemberDTO getMemberById(Long id) {
        System.out.println("id : " + id);
        return memberRepository.getMemberById(id);
    }

    public MemberDTO findByMemberEmail(String memberEmail) {
        return memberRepository.findByMemberEmail(memberEmail);
    }

    public String checkEmail(String memberEmail) {

        String dbEmail = memberRepository.checkEmail(memberEmail);
        if(dbEmail != null && dbEmail.equals(memberEmail)){
            return "equals";
        }else{
            return "";
        }

    }
}