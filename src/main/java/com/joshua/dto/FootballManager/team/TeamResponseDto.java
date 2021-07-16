package com.joshua.dto.FootballManager.team;

import com.joshua.domain.FootballManager.Player;
import com.joshua.domain.FootballManager.Team;
import com.joshua.domain.FootballManager.TeamSponsor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamResponseDto {
    private String teamName;
    private List<Player> players;
    private List<TeamSponsor> teamSponsors;

    public TeamResponseDto (Team entity) {
        this.teamName = entity.getTeamName();
        this.players = entity.getPlayers();
        this.teamSponsors = entity.getTeamSponsors();
    }
}
