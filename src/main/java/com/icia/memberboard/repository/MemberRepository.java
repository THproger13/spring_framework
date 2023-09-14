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
    public int save(MemberDTO memberDTO) {
        try {
            return sql.insert("Member.save", memberDTO);
        }catch (Exception e) {
            e.getCause();
            e.printStackTrace();
            System.out.println("e = " + e);
            return 0;
        }
    }
    public void saveProfile(MemberProfileDTO memberProfileDTO) {
        sql.insert("Board.saveProfile", MemberProfileDTO);
    }
}
