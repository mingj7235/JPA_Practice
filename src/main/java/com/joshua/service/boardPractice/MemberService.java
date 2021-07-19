package com.joshua.service.boardPractice;


import com.joshua.domain.boardPractice.Member;
import com.joshua.dto.boardPractice.member.MemberResponseDto;
import com.joshua.dto.boardPractice.member.MemberSaveRequestDto;
import com.joshua.dto.boardPractice.member.MemberUpdateRequestDto;
import com.joshua.repository.boardPractice.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long saveMember (MemberSaveRequestDto requestDto) {
        Member member = requestDto.toEntity();
        return memberRepository.save(member).getId();
    }

    @Transactional
    public Long updateMember (Long id, MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("찾는 멤버 없슴"));
        member.setMemberName(requestDto.getMemberName());
        member.setMemberAge(requestDto.getMemberAge());

        return memberRepository.save(member).getId();
    }

    @Transactional
    public void deleteMember (Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 멤버 없슴"));
        memberRepository.delete(member);
    }

    @Transactional
    public MemberResponseDto findMemberById (Long id)  {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 멤버가 없어요"));
        System.out.println(member.getMemberName() + ", " + member.getMemberAge());
        return new MemberResponseDto(member);
    }

}
