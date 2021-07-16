package com.joshua.controller.footballManager;

import com.joshua.dto.FootballManager.team.TeamResponseDto;
import com.joshua.dto.FootballManager.team.TeamSaveRequestDto;
import com.joshua.dto.FootballManager.team.TeamUpdateRequestDto;
import com.joshua.service.FootballManager.Team_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

}
