package com.joshua.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
//@Entity
public class Member {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(value = TemporalType.DATE)
    private Date date;

    @Temporal(value = TemporalType.TIME)
    private Date time;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timestamp;
}
