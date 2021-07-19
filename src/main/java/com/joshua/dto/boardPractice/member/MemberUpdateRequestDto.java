package com.joshua.dto.boardPractice.member;

import com.joshua.domain.boardPractice.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateRequestDto {
    private String memberName;
    private Integer memberAge;

//    public Member toEntity () {
//        return Member.builder()
//                .memberName(memberName)
//                .memberAge(memberAge)
//                .build();
//    }
}
