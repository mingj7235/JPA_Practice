package com.joshua.dto.FootballManager.player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerUpdateRequestDto {
    private String name;
    private Long team_id;

    @Builder
    public PlayerUpdateRequestDto(String name, Long team_id) {
        this.name = name;
        this.team_id = team_id;
    }
}
