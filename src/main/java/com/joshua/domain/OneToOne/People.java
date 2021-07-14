package com.joshua.domain.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class People {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String peopleName;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID") //관계의 주인
    private Locker locker;

}
