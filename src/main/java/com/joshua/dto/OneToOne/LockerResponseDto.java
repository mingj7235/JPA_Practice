package com.joshua.dto.OneToOne;

import com.joshua.domain.OneToOne.Locker;
import com.joshua.domain.OneToOne.People;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LockerResponseDto {

    private String lockerName;
    private String password;
    private People people;

    public LockerResponseDto (Locker entity) {
        this.lockerName = entity.getLockerName();
        this.password = entity.getPassword();
        this.people = entity.getPeople();
    }


}
