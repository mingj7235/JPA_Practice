package com.joshua.controller.boardPractice;

import com.joshua.dto.boardPractice.member.MemberSaveRequestDto;
import com.joshua.service.boardPractice.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberAPIController {
    private final MemberService memberService;

    @PostMapping ("/member/save")
    public void saveMember (MemberSaveRequestDto requestDto) {
        memberService.saveMember(requestDto);
    }


}
