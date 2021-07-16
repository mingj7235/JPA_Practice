package com.joshua.service.FootballManager;

import com.joshua.domain.FootballManager.Team;
import com.joshua.dto.FootballManager.team.TeamResponseDto;
import com.joshua.dto.FootballManager.team.TeamSaveRequestDto;
import com.joshua.dto.FootballManager.team.TeamUpdateRequestDto;
import com.joshua.repository.FootballManager.ManagerRepository;
import com.joshua.repository.FootballManager.TeamRepository;
import com.joshua.repository.FootballManager.TeamSponsorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class Team_Service {
    private final TeamRepository teamRepository;
    private final ManagerRepository managerRepository;
    private final TeamSponsorRepository teamSponsorRepository;

    @Transactional
    public void saveTeam (TeamSaveRequestDto requestDto) {
        Team team = requestDto.toEntity();
        team.setManager(managerRepository.findById(requestDto.getManager_id())
        .orElseThrow(() -> new IllegalArgumentException("찾는 매니저가 없습니다.")));
        teamRepository.save(team);
    }

    @Transactional
    public void updateTeam (Long id, TeamUpdateRequestDto requestDto) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 팀 없슈"));

        team.setTeamName(requestDto.getTeamName());
        team.setManager(managerRepository.findById(requestDto.getManager_id())
                .orElseThrow(() -> new IllegalArgumentException("찾는 매니저 없슈")));
    }

    @Transactional
    public void deleteTeam (Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 팀이 없슈"));
        teamRepository.delete(team);
    }

    public TeamResponseDto findTeam (Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("찾는 팀 없슈"));

        return new TeamResponseDto(team);
    }
}






















