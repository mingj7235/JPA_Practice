package com.joshua.service;

import com.joshua.domain.OneToOne.Locker;
import com.joshua.domain.OneToOne.People;
import com.joshua.dto.OneToOne.PeopleSaveRequestDto;
import com.joshua.repository.OneToOne.LockerRepository;
import com.joshua.repository.OneToOne.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OneToOne_Service {

    private final PeopleRepository peopleRepository;
    private final LockerRepository lockerRepository;
    private final EntityManager em;

    @Transactional
    public Long save (PeopleSaveRequestDto requestDto) throws Exception{
        Locker locker1 = new Locker();
        locker1.setName("락커1");
        Locker locker2 = new Locker();
        locker2.setName("락커2");
        em.persist(locker1);
        em.persist(locker2);

        People entity = requestDto.toEntity();
        //Optional<Locker> locker = lockerRepository.findById(requestDto.getLocker_id());
        //locker.ifPresent(entity::setLocker);

        entity.setLocker(lockerRepository.findById(requestDto.getLocker_id()).orElseThrow(Exception::new));
        //Optional : get() : O ->
        //orElse ('세팅값') -> get을 하려는데, 값이 있으면 get과 같은 응답을주고, null인경우, '세팅값'을 리턴한다.
        //orElseGet('값을 생성하는 메서드가 들어간다. 값도 들어갈수있다.') -> 메모리절약.
        //orElseThrow(exception) : null일때 exception을 던짐
        return peopleRepository.save(entity).getId();
    }

//    private final EntityManager em;
//
//    @Transactional
//    public void oneToone () {
//        People people = new People();
//        people.setPeopleName("주인");
//
//        Locker locker = new Locker();
//        locker.setName("락커");
//
//        people.setLocker(locker);
//        locker.setPeople(people);
//
//        em.persist(locker);
//        em.persist(people);
//    }
//
//    public void oneToone_find () {
//        People people = em.find(People.class, 1L);
//        Locker locker = em.find(Locker.class, 1L);
//
//        System.out.println("people객체 통해 locker 이름 가져오기" + people.getLocker().getName());
//        System.out.println("locker객체 통해 people 이름 가져오기" + locker.getPeople().getPeopleName());
//
//    }


}
