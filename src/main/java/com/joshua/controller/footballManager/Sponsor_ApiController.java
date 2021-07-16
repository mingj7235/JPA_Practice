package com.joshua.controller.footballManager;

import com.joshua.domain.FootballManager.Sponsor;
import com.joshua.domain.FootballManager.Team;
import com.joshua.domain.FootballManager.TeamSponsor;
import com.joshua.dto.FootballManager.sponsor.SponsorSaveRequestDto;
import com.joshua.dto.FootballManager.sponsor.SponsorUpdateRequestDto;
import com.joshua.dto.FootballManager.team.TeamResponseDto;
import com.joshua.service.FootballManager.Sponsor_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Sponsor_ApiController {
    private final Sponsor_Service sponserService;

    @PostMapping ("/fm/sponsor/save")
    public void saveSponsor (SponsorSaveRequestDto requestDto) {
        sponserService.saveSponsor(requestDto);
    }

    @PutMapping ("/fm/sponsor/update/{id}")
    public void updateSponsor (@PathVariable Long id, SponsorUpdateRequestDto requestDto) {
        sponserService.updateSponsor(id, requestDto);
    }

    @DeleteMapping ("/fm/sponsor/delete/{id}")
    public void deleteSponsor(@PathVariable Long id) {
        sponserService.deleteSponsor(id);
    }

    @PostMapping ("/fm/sponsor/find/{id}")
    public void findSponsor (@PathVariable Long id) {
        sponserService.findSponsor(id);
    }

    @PostMapping ("/fm/sponsor/findteamsbysponsor/{id}")
    public void findTeamsBySponsor (@PathVariable Long id) {
        String sponsorName = sponserService.findSponsor(id).getSponsorName();
        List<TeamSponsor> teams = sponserService.findSponsor(id).getTeamSponsors();
        String result = "";
        for (int i = 0; i < teams.size(); i ++) {
            String teamName = teams.get(i).getTeam().getTeamName();
            if (i == teams.size() -1 ) {
                result += teamName;
            } else {
                result += teamName + ", ";
            }
        }
        System.out.println(sponsorName + " 이(가) 지원하는 팀들은 " + result + "입니다.");

    }




}
