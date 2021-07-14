package com.joshua.service;

import com.joshua.domain.OneToMany_ManyToOne.Student;
import com.joshua.domain.OneToMany_ManyToOne.StudentSubject;
import com.joshua.domain.OneToMany_ManyToOne.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class OneToMany_Service {
    private final EntityManager em;

    @Transactional
    public void oneToMany () {
        Subject subject = new Subject();
        subject.setSubjectName("과학");
        em.persist(subject);

        Student student = new Student();
        student.setStudentName("학생");
        em.persist(student);

        StudentSubject sts = new StudentSubject();
        sts.setSubject(subject);
        sts.setStudent(student);
        sts.setColumnTest("columnTest");

        subject.getStudentSubjects().add(sts);
        student.getStudentSubjects().add(sts);

        em.persist(sts);
    }
}
