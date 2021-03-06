package com.joshua.domain.OneToMany_ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Subject {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectName;

    @OneToMany (mappedBy = "subject")
    private List<StudentSubject> studentSubjects = new ArrayList<>();

}
