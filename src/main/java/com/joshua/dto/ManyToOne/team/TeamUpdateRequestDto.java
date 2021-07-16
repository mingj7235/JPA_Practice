package com.joshua.dto.ManyToOne.team;

import com.joshua.domain.ManyToOne.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamUpdateRequestDto {

    private String teamName;
    private Long manager_id;

    @Builder
    public TeamUpdateRequestDto(String teamName, Long manager_id) {
        this.teamName = teamName;
        this.manager_id = manager_id;
    }
}
