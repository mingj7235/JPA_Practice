package com.joshua.dto.ManyToOne.manager;

import com.joshua.domain.ManyToOne.Manager;
import com.joshua.domain.ManyToOne.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManagerResponseDtd {
    private String managerName;
    private String managerAge;
    private Team team;

    public ManagerResponseDtd (Manager entity) {
        this.managerName = entity.getManagerName();
        this.managerAge = entity.getManagerAge();
        this.team = entity.getTeam();
    }
}
