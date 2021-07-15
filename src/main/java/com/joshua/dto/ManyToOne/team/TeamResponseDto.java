package com.joshua.dto.ManyToOne.team;

import com.joshua.domain.ManyToOne.Player;
import com.joshua.domain.ManyToOne.Team;
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

    public TeamResponseDto (Team entity) {
        this.teamName = entity.getTeamName();
        this.players = entity.getPlayers();
    }
}
