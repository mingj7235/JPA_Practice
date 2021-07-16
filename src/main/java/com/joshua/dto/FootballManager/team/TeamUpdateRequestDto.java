package com.joshua.dto.FootballManager.team;

import com.joshua.domain.FootballManager.League;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamUpdateRequestDto {

    private String teamName;
    private League league;
    private Long manager_id;
//
//    @Builder
//    public TeamUpdateRequestDto(String teamName, League league, Long manager_id) {
//        this.teamName = teamName;
//        this.league = league;
//        this.manager_id = manager_id;
//    }
}
