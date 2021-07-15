package com.joshua.dto.ManyToOne;

import com.joshua.domain.ManyToOne.Player;
import com.joshua.domain.ManyToOne.Postion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerSaveRequestDto {

    private String playerName;
    private String playerAge;
    private Postion postion;
    private Long team_id;

    public Player toEntity () {
        return Player.builder()
                .playerName(playerName)
                .playerAge(playerAge)
                .position(postion)
                .build();
    }
}
