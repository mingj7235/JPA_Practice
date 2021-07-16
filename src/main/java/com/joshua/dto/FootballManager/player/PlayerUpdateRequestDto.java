package com.joshua.dto.FootballManager.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerUpdateRequestDto {
    private String playerName;
    private String playerAge;
    private Long team_id;

    @Builder
    public PlayerUpdateRequestDto(String playerName, String playerAge, Long team_id) {
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.team_id = team_id;
    }
}
