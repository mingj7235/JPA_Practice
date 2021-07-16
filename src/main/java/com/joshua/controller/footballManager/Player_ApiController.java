package com.joshua.controller.footballManager;

import com.joshua.dto.FootballManager.player.PlayerSaveRequestDto;
import com.joshua.dto.FootballManager.player.PlayerUpdateRequestDto;
import com.joshua.service.FootballManager.Player_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Player_ApiController {
    private final Player_Service playerService;

    @PostMapping ("/fm/player/save")
    public void savePlayer (PlayerSaveRequestDto requestDto) {
        playerService.savePlayer(requestDto);
    }

    @PutMapping ("/fm/player/update/{id}")
    public void updatePlayer (@PathVariable Long id, PlayerUpdateRequestDto requestDto) {
        playerService.updatePlayer(id, requestDto);
    }

    @DeleteMapping ("/fm/player/delete/{id}")
    public void deletePlayer (@PathVariable Long id){
        playerService.deletePlayer(id);
    }

    @PostMapping ("/fm/player/find/{id}")
    public void findPlayer (@PathVariable Long id) {
        playerService.findPlayer(id);
    }
}
