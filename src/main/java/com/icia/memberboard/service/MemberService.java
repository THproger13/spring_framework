package com.icia.memberboard.service;

import com.icia.memberboard.dto.MemberDTO;
import com.icia.memberboard.dto.MemberProfileDTO;
import com.icia.memberboard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) throws IOException {
        try {
            //회원 프로필 없다.
            if(memberDTO.getMemberProfile().isEmpty()){
                memberDTO.setMemberProfileAttached(0);
                memberRepository.save(memberDTO);
            }else{
                //회원 프로필 있다.
                memberDTO.setMemberProfileAttached(1);
                MemberDTO savedMember = memberRepository.save(memberDTO);
                // 파일만 따로 가져오기
                MultipartFile memberProfile = memberDTO.getMemberProfile();
                // 파일 이름 가져오기
                String originalFilename = memberProfile.getOriginalFilename();
                System.out.println("originalFilename = " + originalFilename);
                // 저장용 이름 만들기
                System.out.println(System.currentTimeMillis());
                String storedFileName = System.currentTimeMillis() + "-" + originalFilename;
                System.out.println("storedFileName = " + storedFileName);
                // BoardFileDTO 세팅
                MemberProfileDTO memberProfileDTO = new MemberProfileDTO();
                memberProfileDTO.setOriginalProfileName(originalFilename);
                memberProfileDTO.setStoredProfileName(storedFileName);
                memberProfileDTO.setMemberId(savedMember.getMemberId());
                // 파일 저장용 폴더에 파일 저장 처리
                String savePath = "C:\\spring_img\\" + storedFileName;
                memberProfile.transferTo(new File(savePath));
                // board_file_table 저장 처리
                memberRepository.saveProfile(memberProfileDTO);
            }
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }

    }
}
