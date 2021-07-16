package com.joshua.domain.FootballManager;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Sponsor {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String sponsorName;
    private Integer budget;

    @OneToMany (mappedBy = "sponsor")
    private List<TeamSponsor> teamSponsors = new ArrayList<>();

    @Builder
    public Sponsor(String sponsorName, Integer budget) {
        this.sponsorName = sponsorName;
        this.budget = budget;
    }
}
