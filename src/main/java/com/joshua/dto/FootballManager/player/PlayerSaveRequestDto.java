package com.joshua.dto.FootballManager.player;

import com.joshua.domain.FootballManager.Player;
import com.joshua.domain.FootballManager.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerSaveRequestDto {

    private String playerName;
    private String playerAge;
    private Position position;
    private Long team_id;

    public Player toEntity () {
        return Player.builder()
                .playerName(playerName)
                .playerAge(playerAge)
                .position(position)
                .build();
    }
}
