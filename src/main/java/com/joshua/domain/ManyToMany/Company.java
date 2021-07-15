package com.joshua.domain.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Company {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;


}
