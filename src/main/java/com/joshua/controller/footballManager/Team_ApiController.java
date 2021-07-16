package com.joshua.controller.footballManager;

import com.joshua.domain.FootballManager.TeamSponsor;
import com.joshua.dto.FootballManager.team.TeamSaveRequestDto;
import com.joshua.dto.FootballManager.team.TeamUpdateRequestDto;
import com.joshua.service.FootballManager.Team_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Team_ApiController {

    private final Team_Service teamService;

    @PostMapping ("/fm/team/save")
    public void saveTeam (TeamSaveRequestDto requestDto) {
        teamService.saveTeam(requestDto);
    }

    @PutMapping ("/fm/team/update/{id}")
    public void updateTeam (@PathVariable Long id, TeamUpdateRequestDto requestDto) {
        teamService.updateTeam(id, requestDto);
    }

    @DeleteMapping ("/fm/team/delete/{id}")
    public void deleteTeam (@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

    @PostMapping ("/fm/team/findteam/{id}")
    public void findTeam (@PathVariable Long id) {
        teamService.findTeam(id);

    }

    @PostMapping ("/fm/team/findsponsorbyteam/{id}")
    public void findSponsorByTeam (@PathVariable Long id) {
        String teamName = teamService.findTeam(id).getTeamName();
        List<TeamSponsor> sponsors = teamService.findTeam(id).getTeamSponsors();

        String result = "";

        for (int i = 0; i < sponsors.size() ; i++) {
            String sponsorsName = sponsors.get(i).getSponsor().getSponsorName();
            if (i == sponsors.size() -1) {
                result += sponsorsName;
            } else {
                result += sponsorsName + ", ";
            }
        }
        System.out.println(teamName + "의 스폰서들은 다음과 같습니다. " + result);

    }

}
