package com.joshua.domain.OneToMany_ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class StudentSubject {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "STUDENT_ID")
    private Student student;

    @ManyToOne
    @JoinColumn (name = "SUBJECT_ID")
    private Subject subject;

    private String columnTest;
}
