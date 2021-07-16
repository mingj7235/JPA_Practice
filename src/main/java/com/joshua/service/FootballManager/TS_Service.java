package com.joshua.service.FootballManager;

import com.joshua.domain.FootballManager.TeamSponsor;
import com.joshua.dto.FootballManager.team_sponsor.TSSaveRequestDto;
import com.joshua.repository.FootballManager.SponsorRepository;
import com.joshua.repository.FootballManager.TeamRepository;
import com.joshua.repository.FootballManager.TeamSponsorRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TS_Service {
    private final TeamRepository teamRepository;
    private final SponsorRepository sponsorRepository;
    private final TeamSponsorRepository teamSponsorRepository;

    @Transactional
    public void saveTS (TSSaveRequestDto requestDto) {
        TeamSponsor teamSponsor = new TeamSponsor();
        teamSponsor.setTeam(teamRepository.findById(requestDto.getTeam_id())
                .orElseThrow(() -> new IllegalArgumentException("팀이없슴")));
        teamSponsor.setSponsor(sponsorRepository.findById(requestDto.getSponsor_id())
                .orElseThrow(() -> new IllegalArgumentException("스폰서가 없슴")));
        teamSponsorRepository.save(teamSponsor);
    }


}
