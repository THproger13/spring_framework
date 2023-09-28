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

    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute StudentDTO studentDTO) {
        boolean result = studentService.save(studentDTO);
        if (result) {
            System.out.println("학생등록 성공");
            return "index";
        } else {
            System.out.println("학생등록 실패");
            return "save";
        }
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<StudentDTO> studentDTOList = studentService.findAll();
        model.addAttribute("studentList", studentDTOList); // => 화면에 가져갈 데이터
        return "list"; // => 브라우저에 출력할 jsp 파일 이름
    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long id, Model model) {
        StudentDTO studentDTO = studentService.findById(id);
        model.addAttribute("student", studentDTO);
        return "detail";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {
        StudentDTO studentDTO = studentService.findById(id);
        model.addAttribute("student", studentDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute StudentDTO studentDTO) {
        studentService.update(studentDTO);
        // 수정처리 후 redirect 방식으로 /list 주소값 요청
        // redirect를 사용하지 않으면 빈 껍데기만 출력이 된다.
        //redirect:/list를 사용하면 CONTROLLER의 LIST메서드를 거쳐서 값을 리턴하게 된다.
        //redirect방식은 브라우저의 주소창에 리다이랙트 한 주소가 http://localhost:8081/list가 출력됨
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        studentService.delete(id);

        // redirect 방식 쓰지 않고 리스트 가져와서 list.jsp로 이동
        //삭제 처리는 밑의 두 줄을 직접 써줌으로써 리스트 데이터를 직접 가져가는
        //형식을 쓴다.
        //dispatch 방식은 브라우저의 주소창에 http://localhost:8081/delete?id=1가 뜬다.

        List<StudentDTO> studentDTOList = studentService.findAll();
        model.addAttribute("studentList", studentDTOList);
        return "list";
    }

}