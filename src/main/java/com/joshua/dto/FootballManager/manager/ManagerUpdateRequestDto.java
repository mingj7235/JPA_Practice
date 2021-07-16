package com.joshua.dto.FootballManager.manager;

import com.joshua.domain.FootballManager.Manager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManagerUpdateRequestDto {
    private String managerName;
    private String managerAge;

//    public Manager toEntity () {
//        return Manager.builder()
//                .managerName(managerName)
//                .managerAge(managerAge)
//                .build();
//    }


}
