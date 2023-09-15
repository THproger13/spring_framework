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
                String originalProfileName = memberProfile.getOriginalFilename();
                System.out.println("originalProfileName = " + originalProfileName);
                // 저장용 이름 만들기
                System.out.println(System.currentTimeMillis());
                String storedProfileName = System.currentTimeMillis() + "-" + originalProfileName;
                System.out.println("storedFileName = " + storedProfileName);
                // BoardFileDTO 세팅
                MemberProfileDTO memberProfileDTO = new MemberProfileDTO();
                memberProfileDTO.setOriginalProfileName(originalProfileName);
                memberProfileDTO.setStoredProfileName(storedProfileName);
                memberProfileDTO.setMemberId(savedMember.getMemberId());
                // 파일 저장용 폴더에 파일 저장 처리
                String savePath = "C:\\spring_member_img\\" + storedProfileName;
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
    public MemberDTO findByMemberEmail(String memberEmail) {
        return memberRepository.findByMemberEmail(memberEmail);
    }

    public boolean login(MemberDTO memberDTO) {
        /*
            1. 이메일, 비밀번호 두 값 모두 일치하는 db 조회결과를 가져옴(조회결과 있으면 로그인 성공)
            2. 이메일로 DB에서 조회해서 서비스에서 비밀번호를 서로 비교하여 일치하면 로그인 성공
         */
        MemberDTO dto = memberRepository.login(memberDTO);
        if (dto != null) {
            return true;
        } else {
            return false;
        }
    }

    public void sampleData(MemberDTO memberDTO) {
        memberDTO.setMemberProfileAttached(0);
        memberRepository.save(memberDTO);
    }
}
