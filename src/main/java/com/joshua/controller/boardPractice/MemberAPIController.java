package com.joshua.controller.boardPractice;

import com.joshua.dto.boardPractice.member.MemberSaveRequestDto;
import com.joshua.dto.boardPractice.member.MemberUpdateRequestDto;
import com.joshua.service.boardPractice.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberAPIController {
    private final MemberService memberService;

    @PostMapping ("/member/save")
    public void saveMember (MemberSaveRequestDto requestDto) {
        memberService.saveMember(requestDto);
    }

    @PutMapping ("/member/update/{id}")
    public void updateMember (@PathVariable Long id, MemberUpdateRequestDto requestDto) {
        memberService.updateMember(id, requestDto);
    }

    @DeleteMapping("/member/delete/{id}")
    public void deleteMember (@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @PostMapping ("/member/findMember/{id}")
    public void findMember (@PathVariable Long id) {
        memberService.findMemberById(id);
    }


}
