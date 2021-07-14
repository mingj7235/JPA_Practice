package com.joshua.domain.OneToOne;

import lombok.Builder;
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
    private String lockerName;
    private String password;

    @OneToOne (mappedBy = "locker")
    private People people;

    @Builder
    public Locker(String lockerName, String password, People people) {
        this.lockerName = lockerName;
        this.password = password;
        this.people = people;
    }
}
