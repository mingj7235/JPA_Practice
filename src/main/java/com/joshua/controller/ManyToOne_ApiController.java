package com.joshua.controller;

import com.joshua.dto.ManyToOne.PlayerSaveRequestDto;
import com.joshua.service.ManyToOne_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManyToOne_ApiController {

    private final ManyToOne_Service manyToOneService;

    @PostMapping ("/player/manytoone/save")
    public void savePlayer (PlayerSaveRequestDto requestDto) {
        manyToOneService.savePlayer(requestDto);
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
