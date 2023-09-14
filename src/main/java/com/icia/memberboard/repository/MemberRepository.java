package com.icia.memberboard.repository;

import com.icia.memberboard.dto.MemberDTO;
import com.icia.memberboard.dto.MemberProfileDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;
    public MemberDTO save(MemberDTO memberDTO) {
        try {
            sql.insert("Member.save", memberDTO);
        }catch (Exception e) {
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }
        return memberDTO;
    }
    public void saveProfile(MemberProfileDTO memberProfileDTO) {
        try {
            sql.insert("Member.saveProfile", memberProfileDTO);
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }
    }

    public MemberDTO findByMemberEmail(String memberEmail) {
        try {
            return sql.selectOne("Member.findByEmail", memberEmail);
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }
        return null;
    }
}
