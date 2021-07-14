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
}
