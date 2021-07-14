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
public class Student {
    /**
     * @ManyToMany의 한계
     * @ManyToMany를 사용하면 중간 연결 테이블을 자동으로 관리하고 생성해주므로 편리하다.
     * 하지만 일반적으로 실무에서는 연결 테이블에 외래키가 담지 않고 추가적인 컬럼이 들어간다.
     * 추가적인 컬럼이 들어갈 경우 @ManyToMany는 더이상 사용할 수 없다.
     *
     * 그래서 직접 새로운 연결 엔터티 (StudentSubject) 를 만들어서 일대다, 다대일 관계를 직접 설정한다.
     *
     */

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;

    @OneToMany(mappedBy = "student")
    private List<StudentSubject> studentSubjects = new ArrayList<>();
    /**
     * StudentSubject 엔터티와 직접 관계를 맺는다. 이는 subject도 마찬가지다.
     */
}
