package com.joshua.dto.FootballManager.sponsor;

import com.joshua.domain.FootballManager.Sponsor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SponsorSaveRequestDto {

    private String sponsorName;
    private Integer budget;

    public Sponsor toEntity () {
        return Sponsor.builder()
                .sponsorName(sponsorName)
                .budget(budget)
                .build();
    }

}
