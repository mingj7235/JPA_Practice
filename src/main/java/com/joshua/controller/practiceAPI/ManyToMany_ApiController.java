package com.joshua.controller.practiceAPI;

import com.joshua.service.ManyToMany_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManyToMany_ApiController {
    private final ManyToMany_Service manyToMany_service;

    @PostMapping ("/member/manytomany")
    public void manyTomany () {
        manyToMany_service.manyTomany();
    }

    @PostMapping ("/member/manytomany/print")
    public void manyTomeny_print () {
        manyToMany_service.manyTomany_find();
    }
}
