package com.joshua.domain.FootballManager;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;

    @Enumerated (value = EnumType.STRING)
    private League league;

    @OneToMany (mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    @OneToOne
    @JoinColumn (name = "MANAGER_ID")
    private Manager manager;

    @OneToMany (mappedBy = "team")
    private List<TeamSponsor> teamSponsors = new ArrayList<>();


    @Builder
    public Team(String teamName, League league, Manager manager) {
        this.teamName = teamName;
        this.league = league;
        this.manager = manager;
    }
}
