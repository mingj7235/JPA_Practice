package com.joshua.dto.ManyToOne;

import com.joshua.domain.ManyToOne.Player;
import com.joshua.domain.ManyToOne.Position;
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
