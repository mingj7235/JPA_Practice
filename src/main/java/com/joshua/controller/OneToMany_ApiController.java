package com.joshua.controller;

import com.joshua.service.OneToMany_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OneToMany_ApiController {
    private final OneToMany_Service oneToMany_service;

    @PostMapping ("/member/onetomany")
    public void oneToMany () {
        oneToMany_service.oneToMany();
    }
}
