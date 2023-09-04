package com.icia.student.service;

import com.icia.student.dto.StudentDTO;
import com.icia.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void reqdb1(StudentDTO studentDTO) {
        try {
            studentRepository.reqdb1(studentDTO);
        } catch (Exception e) {

            e.printStackTrace(); // 에러 스택 트레이스 출력
        };
    }

    public List<StudentDTO> findAll() {
        return studentRepository.findAll();

    }

    public StudentDTO findById(Long id) {
        return studentRepository.findById(id);
    }
}