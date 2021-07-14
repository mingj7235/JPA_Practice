package com.joshua.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @PostMapping ("/member/join")
    public Long join () {
        return 1L;
    }
}
