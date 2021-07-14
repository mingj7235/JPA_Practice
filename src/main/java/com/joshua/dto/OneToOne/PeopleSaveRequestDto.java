package com.joshua.dto.OneToOne;

import com.joshua.domain.OneToOne.Gender;
import com.joshua.domain.OneToOne.People;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PeopleSaveRequestDto {

    private String peopleName;
    private Gender gender;
    private Long locker_id;

//    @Builder
//    public PeopleSaveRequestDto(String peopleName, Long locker_id) {
//        this.peopleName = peopleName;
//        this.locker_id = locker_id;
//    }

    public People toEntity () {
        return People.builder()
                .peopleName(peopleName)
                .gender(gender)
                .build();
    }
}
