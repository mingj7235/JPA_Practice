package com.joshua.domain.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;

    @ManyToOne
    /**
     * @ManyToOne 속성
     *  1. optional : false 일시 연관된 엔터티가 항상 있어야한다.
     *  2. fetch : Lazy, Eager (선호하는 방법은 모두다 Lazy로 바른다음에 동시에 생성될 필요가 있는 테이블은 Eager를 준다.)
     *  3. cascade : 영속성 전이 기능 사용
     *  4. targetEntity : 연관된 엔티티 타입 정보 설정
     */
    @JoinColumn (name = "TEAM_ID")
    /**
     * @JoinColumn 속성
     *  1. name : 매핑할 외래키 이름 (필드명 + "_" + 참조하는 테이블 기본키의 컬럼명 ex> TEAM_ID)
     *  1. referencedColumnName : 외래키가 참조하는 대상 테이블의 컬럼명. 참조하는 테이블 기본키 컬럼명 (반대편 테이블의 기본키)
     *  2. foreignKey(DDL) : 외래키 제약조건을 지정할 수 있다. unique, nullable, insertable, updatable, columnDefinition, table
     */
    private Team team;
}
