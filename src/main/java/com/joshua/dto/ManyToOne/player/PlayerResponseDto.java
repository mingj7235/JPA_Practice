package com.joshua.dto.ManyToOne.player;

import com.joshua.domain.ManyToOne.Player;
import com.joshua.domain.ManyToOne.Position;
import com.joshua.domain.ManyToOne.Team;
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