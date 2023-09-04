package com.icia.student.repository;
import org.mybatis.spring.SqlSessionTemplate;

import com.icia.student.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private SqlSessionTemplate sql;
    public void reqdb1(StudentDTO studentDTO) {
        try {
            sql.insert("Student.save", studentDTO);
        } catch (Exception e) {
            e.printStackTrace(); // 에러 스택 트레이스 출력
        }
    }

    public List<StudentDTO> findAll() {
        try {
            return sql.selectList("Student.findAll");
        } catch (Exception e) {
            e.printStackTrace(); // 에러 스택 트레이스 출력
            return null;
        }
    }

    public StudentDTO findById(Long id) {
        return sql.selectOne("Student.findById", id);
    }

    public void reqdb2(StudentDTO studentDTO) {
        try {
            sql.update("Student.update", studentDTO);
        } catch (Exception e) {
            e.printStackTrace(); // 에러 스택 트레이스 출력
        }
    }

    public List<StudentDTO> findAllupdated() {
        try {
            return sql.selectList("Student.findAllupdated");
        } catch (Exception e) {
            e.printStackTrace(); // 에러 스택 트레이스 출력
            return null;
        }
    }

}