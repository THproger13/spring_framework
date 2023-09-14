package com.icia.memberboard.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberDTO {

    private Long memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberMobile;
    private int memberProfileAttached;
    private MultipartFile memberProfile;
}
