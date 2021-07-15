package com.joshua.dto.ManyToOne.team;

import com.joshua.domain.ManyToOne.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamSaveRequestDto {

    private String teamName;
    private Long manager_id;

    public Team toEntity () {
        return Team.builder()
                .teamName(teamName)
                .build();
    }
}