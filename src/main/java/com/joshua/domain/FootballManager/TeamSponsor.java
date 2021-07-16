package com.joshua.domain.FootballManager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TeamSponsor {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "TEAM_ID")
    private Team team;

    @ManyToOne
    @JoinColumn (name = "SPONSOR_ID")
    private Sponsor sponsor;

}
