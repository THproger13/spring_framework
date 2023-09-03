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
        sql.insert("Login.save", memberDTO);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Login.findAll");
    }

}
