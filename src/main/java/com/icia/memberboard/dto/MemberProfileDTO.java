package com.icia.memberboard.dto;

import lombok.Data;

@Data
public class MemberProfileDTO extends MemberDTO {

    private Long memberProfileId;
    private String originalProfileName;
    private String storedProfileName;

}
