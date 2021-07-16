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

    @OneToMany (mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    @OneToOne
    @JoinColumn (name = "MANAGER_ID")
    private Manager manager;


    @Builder
    public Team(String teamName, Manager manager) {
        this.teamName = teamName;
        this.manager = manager;
    }
}
