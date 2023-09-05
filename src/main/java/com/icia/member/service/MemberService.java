package com.icia.member.service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;


    public void save(MemberDTO memberDTO) {
        memberRepository.save(memberDTO);
    }

    public List<MemberDTO> list() {
        System.out.println(memberRepository.list());
        return memberRepository.list();
    }
}
