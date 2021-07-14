package com.joshua.service;

import com.joshua.domain.ManyToOne.Team;
import com.joshua.domain.ManyToOne.User;
import com.joshua.domain.Member;
import lombok.RequiredArgsConstructor;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ManyToOne_Service {
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

    @Transactional
    public void manyToOne () {
        Team team = new Team();
        team.setTeamName("TeamTest");
        em.persist(team);

        User user = new User();
        user.setUserName("UserTest");

        //양쪽 객체 둘다에게 데이터를 저장해야한다.
        //user와 team의 양방향 설정
        user.setTeam(team);
        team.getUsers().add(user);

        em.persist(user);
    }

    public void manyToOneFind () {
        User user = em.find(User.class, 1L);
        Team team = em.find(Team.class, 1L);

        System.out.println(user.getUserName());
        System.out.println(user.getTeam().getTeamName());

        System.out.println(team.getUsers().get(0).getUserName());
    }


}
