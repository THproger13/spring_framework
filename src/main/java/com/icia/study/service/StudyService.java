package com.icia.study.service;

import com.icia.study.dto.StudyDTO;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class StudyService {
    public void req1() {
        System.out.println("StudyService.req1");
    }
    //req2메서드에서 p1,p2, p3값 출력
    public void req2(String p1, String p2, int p3){
        System.out.println("p1 = " + p1 + ", p2 = " + p2 + ", p3 = " + p3);

    }
    public void req3(StudyDTO studyDTO){
        System.out.println("StudyService.req3");
        System.out.println("studyDTO = " + studyDTO);
    }
    /* req4 메서드
     * StudyDTO 객체를 리턴한다.
     * index.jsp에서 req4 주소를 요청하면
     * 서비스 클래스의 req4메서드가
     * 리턴한 객체 데이터 값을 req4.jsp에 출력함
     * */
    public StudyDTO req4(){
        StudyDTO studyDTO = new StudyDTO();
        studyDTO.setP1("아힝");
        studyDTO.setP1("흐헷");
        studyDTO.setP3(10);

        System.out.println("StudyService.req4");
        return studyDTO;
    }

    /* req5 메서드
     * StudyDTO 객체가 담긴 리스트 객체를 리턴한다.
     * index.jsp에서 req5 주소를 요청하면
     * 서비스 클래스의 req5메서드가
     * 리턴한 객체 데이터 값을 req5.jsp에 출력함
     * */

    public ArrayList<StudyDTO> req5() {
        ArrayList<StudyDTO> studyDTOList= new ArrayList<>();
        for(int i = 0 ; i <= 10 ; i++ ){
            StudyDTO studyDTO = new StudyDTO();
            studyDTO.setP1("p1값 : " + i);
            studyDTO.setP2("p2값 : " + i);
            studyDTO.setP3(i);
            studyDTOList.add(studyDTO);
        }
        System.out.println("StudyService.req5");
        System.out.println("studyDTOList = " + studyDTOList);
        return studyDTOList;
    }



}
