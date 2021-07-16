package com.joshua.domain.FootballManager;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Manager {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String managerName;
    private String managerAge;

    @OneToOne (mappedBy = "manager")
    private Team team;

    @Builder
    public Manager(String managerName, String managerAge, Team team) {
        this.managerName = managerName;
        this.managerAge = managerAge;
        this.team = team;
    }
}
