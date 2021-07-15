package com.joshua.dto.OneToOne;

import com.joshua.domain.OneToOne.Locker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LockerSaveRequestDto {

    private String lockerName;
    private String password;
    private Long people_id;

    public Locker toEntity () {
       return Locker.builder()
                .lockerName(lockerName)
                .password(password)
                .build();
    }

}
