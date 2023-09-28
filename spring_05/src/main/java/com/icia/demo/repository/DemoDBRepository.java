package com.icia.demo.repository;

import com.icia.demo.dto.DemoDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DemoDBRepository {
@Autowired
private SqlSessionTemplate sql;
//"Demo.save"는 namespace에 Demo들어감, demo-mapper의 id에 save가,
    public void reqdb1(DemoDTO demoDTO) {
        sql.insert("Demo.save", demoDTO);
    }

    public List<DemoDTO> findAll() {
        return sql.selectList("Demo.findAll");
    }

    public DemoDTO findById(Long id) {
        return sql.selectOne("Demo.findById", id);
    }
}
