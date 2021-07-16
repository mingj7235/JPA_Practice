package com.joshua.controller.footballManager;

import com.joshua.dto.FootballManager.team_sponsor.TSSaveRequestDto;
import com.joshua.service.FootballManager.TS_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TS_ApiController {
    private final TS_Service tsService;

    @PostMapping("/fm/ts/save")
    public void saveTs (TSSaveRequestDto requestDto) {
        tsService.saveTS(requestDto);
    }
 }
