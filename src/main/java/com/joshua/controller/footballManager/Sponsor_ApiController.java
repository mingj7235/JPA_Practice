package com.joshua.controller.footballManager;

import com.joshua.dto.FootballManager.sponsor.SponsorSaveRequestDto;
import com.joshua.dto.FootballManager.sponsor.SponsorUpdateRequestDto;
import com.joshua.service.FootballManager.Sponser_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Sponsor_ApiController {
    private final Sponser_Service sponserService;

    @PostMapping ("/fm/sponsor/save")
    public void saveSponsor (SponsorSaveRequestDto requestDto) {
        sponserService.saveSponsor(requestDto);
    }

    @PutMapping ("/fm/sponsor/update/{id}")
    public void updateSponsor (@PathVariable Long id, SponsorUpdateRequestDto requestDto) {
        sponserService.updateSponsor(id, requestDto);
    }



}
