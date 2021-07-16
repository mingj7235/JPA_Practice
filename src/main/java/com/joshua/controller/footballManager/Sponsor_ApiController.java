package com.joshua.controller.footballManager;

import com.joshua.dto.FootballManager.sponsor.SponsorSaveRequestDto;
import com.joshua.service.FootballManager.Sponser_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Sponsor_ApiController {
    private final Sponser_Service sponserService;

    @PostMapping ("/fm/sponsor/save")
    public void saveSponsor (SponsorSaveRequestDto requestDto) {
        sponserService.saveSponsor(requestDto);
    }

}
