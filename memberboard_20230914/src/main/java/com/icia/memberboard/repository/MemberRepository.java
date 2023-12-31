package com.icia.memberboard.repository;

import com.icia.memberboard.dto.MemberDTO;
import com.icia.memberboard.dto.MemberProfileDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public MemberDTO findByMemberEmail(String email) {
        try {
            return sql.selectOne("Member.findByEmail", email);
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }
        return null;
    }

    public MemberDTO login(MemberDTO memberDTO) {
        try {
            return sql.selectOne("Member.login", memberDTO);
        }catch (Exception e) {
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }
        return memberDTO;
        }

    public void delete(Long memberId) {
        try {
            sql.delete("Member.delete", memberId);
        }catch (Exception e) {
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }
    }

    public List<MemberDTO> findAll() {
        try {
            List<MemberDTO> dbMemberlist = sql.selectList("Member.findAll");
            return dbMemberlist;

        }catch (Exception e) {
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
        }
        return null;
    }

    public MemberDTO findById(Long memberId) {
        MemberDTO dbmember = sql.selectOne("Member.findById", memberId);
        return dbmember;
    }

    public MemberProfileDTO findMemberProfile(Long memberId) {
        return sql.selectOne("Member.findMemberProfile", memberId);
    }

    public void update(MemberDTO memberDTO) {
        sql.update("Member.update", memberDTO);
    }
}
