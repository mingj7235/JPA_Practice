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
public class Product {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;

    @OneToMany (mappedBy = "products")
    private List<MemberProduct> memberProducts = new ArrayList<>();

}
