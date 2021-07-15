package com.joshua.dto.ManyToOne.manager;

import com.joshua.domain.ManyToOne.Manager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManagerSaveRequestDto {

    private String managerName;
    private String managerAge;
    private Long team_id;

    public Manager toEntity () {
        return Manager.builder()
                .managerName(managerName)
                .managerAge(managerAge)
                .build();
    }
}
