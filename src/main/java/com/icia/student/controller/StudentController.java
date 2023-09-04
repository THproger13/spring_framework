package com.icia.student.controller;

import com.icia.student.dto.StudentDTO;
import com.icia.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/update")
    public String update() {
        return "list";
    }


    @PostMapping("/reqdb2")
    public String reqdb2(@ModelAttribute StudentDTO studentDTO) {
        try {
            studentService.reqdb2(studentDTO);
        } catch (Exception e) {
            e.printStackTrace(); // 에러 스택 트레이스 출력
        }
        return "index";
    }

    @GetMapping("/save")
    public String list() {
        return "save";
    }


    @PostMapping("/reqdb1")
    public String reqdb1(@ModelAttribute StudentDTO studentDTO) {
        try {
            studentService.reqdb1(studentDTO);
        } catch (Exception e) {
            e.printStackTrace(); // 에러 스택 트레이스 출력
        }
        return "index";
    }

    @GetMapping("/list")
    public String memberdblist(Model model) {
        List<StudentDTO> studentDTOList = studentService.findAll();
        System.out.println("studentDTOList = " + studentDTOList);
        model.addAttribute("studentDTOList", studentDTOList);
        return "list";
    }
    @GetMapping("/find")
    public String findById(@RequestParam("id") Long id, Model model) {
        StudentDTO studentDTO = studentService.findById(id);
        System.out.println("student = " + studentDTO);
        model.addAttribute("student", studentDTO);
        return "detail";
    }
}