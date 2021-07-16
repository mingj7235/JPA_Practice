package com.joshua.dto.FootballManager.manager;

import com.joshua.domain.FootballManager.Manager;
import com.joshua.domain.FootballManager.Team;
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
