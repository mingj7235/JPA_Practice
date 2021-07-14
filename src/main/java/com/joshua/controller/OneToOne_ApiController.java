package com.joshua.controller;

import com.joshua.service.OneToOne_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OneToOne_ApiController {
    private final OneToOne_Service oneToOne_service;

    @PostMapping("/member/onetoone")
    public void oneToOne() {
        oneToOne_service.oneToone();
    }

    @PostMapping ("/member/onetoone/print")
    public void onoToone_print() {
        oneToOne_service.oneToone_find();
    }

}
