package com.joshua.controller;

import com.joshua.dto.OneToOne.LockerSaveRequestDto;
import com.joshua.dto.OneToOne.PeopleSaveRequestDto;
import com.joshua.service.OneToOne_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OneToOne_ApiController {
    private final OneToOne_Service oneToOne_service;

    @PostMapping("/member/onetoone/save")
    public void oneToOne(PeopleSaveRequestDto requestDto) throws Exception{
        oneToOne_service.save(requestDto);
    }

    @PostMapping("/locker/onetoone/save")
    public void oneTooneLocker (LockerSaveRequestDto requestDto) {
        oneToOne_service.saveLocker(requestDto);
    }

    @PostMapping ("/member/onetoone/find")
    public void findbyid (Long id) {
        oneToOne_service.findPeople(id);
    }

    @PostMapping ("/locker/onetoone/find")
    public void findbyidLocker (Long id) {
        oneToOne_service.findLocker(id);
    }

//    @PostMapping ("/member/onetoone/print")
//    public void onoToone_print() {
//        oneToOne_service.oneToone_find();
//    }

}
