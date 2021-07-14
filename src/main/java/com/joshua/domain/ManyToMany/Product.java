package com.joshua.domain.ManyToMany;

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

    @ManyToMany (mappedBy = "products")
    private List<Customer> customers = new ArrayList<>();
}
