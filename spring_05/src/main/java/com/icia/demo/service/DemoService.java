package com.icia.demo.service;

import com.icia.demo.dto.DemoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {

    public DemoDTO req1(String name, int age) {
        System.out.println("DemoService.req1");
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName(name);
        demoDTO.setAge(age);
        System.out.println("demoDTO = " + demoDTO);
        return demoDTO;
    }

    public List<DemoDTO> req2(DemoDTO demoDTO) {
        System.out.println("demoDTO = " + demoDTO);
        List<DemoDTO> demoDTOList = new ArrayList<>();

        demoDTOList.add(demoDTO);
        return demoDTOList;
    }

//    public void req2(String q1, String q2) {
//        System.out.println("StudyService.req2");
//        System.out.println("q1 = " + q1 + ", q2 = " + q2);
//    }
//
//    public void req3(StudyDTO studyDTO) {
//        System.out.println("StudyService.req3");
//        System.out.println("studyDTO = " + studyDTO);
//    }
//
//    public StudyDTO req4() {
//        StudyDTO studyDTO = new StudyDTO();
//        studyDTO.setP1("하하하");
//        studyDTO.setP2("ㅋㅋㅋ");
//        studyDTO.setP3(100);
//        return studyDTO;
//    }

}