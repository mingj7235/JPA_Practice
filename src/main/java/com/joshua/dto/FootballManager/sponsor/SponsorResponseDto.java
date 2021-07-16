package com.joshua.dto.FootballManager.sponsor;

import com.joshua.domain.FootballManager.Sponsor;
import com.joshua.domain.FootballManager.TeamSponsor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SponsorResponseDto {
    private String sponsorName;
    private Integer budget;
    private List<TeamSponsor> teamSponsors = new ArrayList<>();

    public SponsorResponseDto (Sponsor entity) {
        this.sponsorName = entity.getSponsorName();
        this.budget = entity.getBudget();
        this.teamSponsors = entity.getTeamSponsors();
    }

}
