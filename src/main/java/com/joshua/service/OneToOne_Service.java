package com.joshua.service;

import com.joshua.domain.OneToOne.Locker;
import com.joshua.domain.OneToOne.People;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class OneToOne_Service {
    private final EntityManager em;

    @Transactional
    public void oneToone () {
        People people = new People();
        people.setPeopleName("주인");

        Locker locker = new Locker();
        locker.setName("락커");

        people.setLocker(locker);
        locker.setPeople(people);

        em.persist(locker);
        em.persist(people);
    }

    public void oneToone_find () {
        People people = em.find(People.class, 1L);
        Locker locker = em.find(Locker.class, 1L);

        System.out.println("people객체 통해 locker 이름 가져오기" + people.getLocker().getName());
        System.out.println("locker객체 통해 people 이름 가져오기" + locker.getPeople().getPeopleName());

    }

}
