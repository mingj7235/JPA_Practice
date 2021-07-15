package com.joshua.controller;

import com.joshua.domain.ManyToOne.Position;
import com.joshua.dto.ManyToOne.PlayerSaveRequestDto;
import com.joshua.dto.ManyToOne.PlayerUpdateRequestDto;
import com.joshua.dto.ManyToOne.TeamSaveRequestDto;
import com.joshua.service.ManyToOne_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ManyToOne_ApiController {

    private final ManyToOne_Service manyToOneService;

    @PostMapping ("/player/manytoone/save")
    public void savePlayer (PlayerSaveRequestDto requestDto) {
        manyToOneService.savePlayer(requestDto);
    }

    @PostMapping ("/player/manytoone/findbyid")
    public void findPlayerById (Long id) {
        manyToOneService.findPlayerById(id);
    }

    @PostMapping ("/player/manytoone/findbypostion")
    public void findPlayerByPostion (Position position) {
        manyToOneService.findPlayerByPostion(position);
    }

    @PostMapping ("/player/manytoone/findbyname")
    public void findPlayerByName (String name) {
        manyToOneService.findPlayerByName(name);
    }

    @PutMapping ("/player/manytoone/update/{id}")
    public void updatePlayer (@PathVariable Long id, PlayerUpdateRequestDto requestDto) {
        manyToOneService.updatePlayer(id, requestDto);
    }

    @PostMapping ("/team/manytoone/save")
    public void saveTeam (TeamSaveRequestDto requestDto) {
        manyToOneService.saveTeam(requestDto);
    }

    @PostMapping ("/team/manytoone/findplayersbyteam")
    public void findplayersbyteam (Long teamId) {
        manyToOneService.findPlayersByTeam(teamId);
    }

    @DeleteMapping ("/team/manytoone/deleteteam/{id}")
    public void deleteTeam (@PathVariable Long id) {
        manyToOneService.deleteTeam(id);
    }


//    @PostMapping ("/member/join")
//    public void test () {
//        testService.test();
//    }

//    @PostMapping ("/member/manytoone")
//    public void manyToOne () {
//        manyToOneService.manyToOne();
//    }
//
//    @PostMapping ("/member/manytoone/print")
//    public void manytooneprint () {
//        manyToOneService.manyToOneFind();
//    }


}
