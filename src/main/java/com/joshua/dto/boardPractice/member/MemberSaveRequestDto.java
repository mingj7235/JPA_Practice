package com.joshua.dto.boardPractice.member;

import com.joshua.domain.boardPractice.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.NoRepositoryBean;

@Getter
@Setter
@NoRepositoryBean
public class MemberSaveRequestDto {

    private String memberName;
    private Integer memberAge;

    public Member toEntity () {
        return Member.builder()
                .memberName(memberName)
                .memberAge(memberAge)
                .build();
    }

}
