package com.joshua.controller;

import com.joshua.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final TestService testService;

    @PostMapping ("/member/join")
    public void test () {
        testService.test();
    }

}
