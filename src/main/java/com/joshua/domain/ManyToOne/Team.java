package com.joshua.domain.ManyToOne;

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

    @Builder
    public Team(String teamName) {
        this.teamName = teamName;
    }
}
