package com.icia.login.service;

import com.icia.login.dto.MemberDTO;
import com.icia.login.repository.MemberDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class MemberDBService {
    @Autowired
    private MemberDBRepository memberDBRepository;

    public void reqdb1(MemberDTO memberDTO) {
        memberDBRepository.reqdb1(memberDTO);
    }
}
