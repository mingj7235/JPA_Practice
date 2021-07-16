package com.joshua.dto.FootballManager.sponsor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SponsorUpdateRequestDto {
    private String sponsorName;
    private Integer budget;

}
