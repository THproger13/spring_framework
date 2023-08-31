package com.icia.study.controller;

import com.icia.study.dto.StudyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

}
