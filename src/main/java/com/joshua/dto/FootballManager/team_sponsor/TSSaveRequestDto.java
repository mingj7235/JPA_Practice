package com.joshua.dto.FootballManager.team_sponsor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TSSaveRequestDto {
    private Long team_id;
    private Long sponsor_id;

}
