package com.joshua.domain.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Locker {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToOne (mappedBy = "locker")
    private People people;

}
