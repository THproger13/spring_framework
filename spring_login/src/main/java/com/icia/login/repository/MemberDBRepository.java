package com.icia.login.repository;
import org.mybatis.spring.SqlSessionTemplate;

import com.icia.login.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDBRepository {

    @Autowired
    private SqlSessionTemplate sql;
    public void reqdb1(MemberDTO memberDTO) {
        try {
            sql.insert("Login.save", memberDTO);
        } catch (Exception e) {
            e.printStackTrace(); // 에러 스택 트레이스 출력
        }
    }

    public List<MemberDTO> findAll() {
        try {
            return sql.selectList("Login.findAll");
        } catch (Exception e) {
            e.printStackTrace(); // 에러 스택 트레이스 출력
            return null;
        }
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Login.findById", id);
    }

}
