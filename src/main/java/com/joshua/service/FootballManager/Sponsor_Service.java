package com.joshua.service.FootballManager;

import com.joshua.domain.FootballManager.Sponsor;
import com.joshua.dto.FootballManager.sponsor.SponsorResponseDto;
import com.joshua.dto.FootballManager.sponsor.SponsorSaveRequestDto;
import com.joshua.dto.FootballManager.sponsor.SponsorUpdateRequestDto;
import com.joshua.repository.FootballManager.SponsorRepository;
import com.joshua.repository.FootballManager.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class Sponsor_Service {
    private final SponsorRepository sponsorRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public void saveSponsor (SponsorSaveRequestDto requestDto) {
        Sponsor sponsor = requestDto.toEntity();
        sponsorRepository.save(sponsor);
    }

    @Transactional
    public void updateSponsor (Long id, SponsorUpdateRequestDto requestDto) {
        Sponsor sponsor = sponsorRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("찾는 스폰서가 없음"));
        sponsor.setSponsorName(requestDto.getSponsorName());
        sponsor.setBudget(requestDto.getBudget());
    }

    @Transactional
    public void deleteSponsor (Long id) {
        Sponsor sponsor = sponsorRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("스폰서없음"));
        sponsorRepository.delete(sponsor);
    }

    @Transactional
    public SponsorResponseDto findSponsor (Long id) {
        Sponsor sponsor = sponsorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("스폰서 없음"));
        return new SponsorResponseDto(sponsor);
    }
}
