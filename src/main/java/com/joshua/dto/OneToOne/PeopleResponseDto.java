package com.joshua.dto.OneToOne;

import com.joshua.domain.OneToOne.Gender;
import com.joshua.domain.OneToOne.Locker;
import com.joshua.domain.OneToOne.People;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PeopleResponseDto {

    private String peopleName;
    private Gender gender;
    private Locker locker;

    public PeopleResponseDto(People entity) {
        this.peopleName = entity.getPeopleName();
        this.gender = entity.getGender();
        this.locker = entity.getLocker();
    }
}
