package com.joshua.service;

import com.joshua.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TestService {
    private final EntityManager em;

    @Transactional
    public void test () {
        Member member = new Member();
        Date date = new Date();
        member.setName("김민재");
        member.setDate(date);
        member.setTime(date);
        member.setTimestamp(date);
        em.persist(member);
    }
}
