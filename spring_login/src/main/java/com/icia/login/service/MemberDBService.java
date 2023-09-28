package com.icia.login.service;

import com.icia.login.dto.MemberDTO;
import com.icia.login.repository.MemberDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberDBService {
    @Autowired
    private MemberDBRepository memberDBRepository;

    public void reqdb1(MemberDTO memberDTO) {
        try {
            memberDBRepository.reqdb1(memberDTO);
        } catch (Exception e) {

            e.printStackTrace(); // 에러 스택 트레이스 출력
        };
    }

    public List<MemberDTO> findAll() {
        return memberDBRepository.findAll();

    }

    public MemberDTO findById(Long id) {
        return memberDBRepository.findById(id);
    }
}
