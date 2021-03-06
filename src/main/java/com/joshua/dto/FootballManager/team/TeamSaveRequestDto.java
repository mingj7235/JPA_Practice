package com.joshua.dto.FootballManager.team;

import com.joshua.domain.FootballManager.League;
import com.joshua.domain.FootballManager.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamSaveRequestDto {

    private String teamName;
    private League league;
    private Long manager_id;

    public Team toEntity () {
        return Team.builder()
                .teamName(teamName)
                .league(league)
                .build();
    }
}
