package com.joshua.dto.FootballManager.player;

import com.joshua.domain.FootballManager.Player;
import com.joshua.domain.FootballManager.Position;
import com.joshua.domain.FootballManager.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerResponseDto {

    private String playerName;
    private String playerAge;
    private Position position;
    private Team team;

    public PlayerResponseDto (Player entity) {
        this.playerName = entity.getPlayerName();
        this.playerAge = entity.getPlayerAge();
        this.position = entity.getPosition();
        this.team = entity.getTeam();

    }

}