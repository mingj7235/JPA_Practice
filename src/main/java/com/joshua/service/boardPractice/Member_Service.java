package com.joshua.service.boardPractice;


import com.joshua.domain.boardPractice.Member;
import com.joshua.dto.boardPractice.member.MemberSaveRequestDto;
import com.joshua.repository.boardPractice.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class Member_Service {
    private final MemberRepository memberRepository;
    @Autowired
    public Member_Service(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long saveMember (MemberSaveRequestDto requestDto) {
        Member member = requestDto.toEntity();
        return memberRepository.save(member).getId();
    }

}
