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
public class Customer {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;

    @ManyToMany
    @JoinTable (name = "CUSTOMER_PRODUCT",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Product> products = new ArrayList<>();
    /**
     * RDB는 다대다를 2개의 테이블로 포현할 수 없다.
     * 그래서 중간에 관계 테이블을 하나 두어 관계를 맺는다. -> CUSTOMER_PRODUCT
     *
     * 하지만, 객체는 테이블과 달리 2개의 객체로 다대다 관계를 표현할 수 있다. -> @ManyToMany
     *
     * @ManyToMany 에서는 @JoinTable을 사용한다.
     * @JoinTable은 연결 테이블을 지정하는 것이다.
     *
     * 결론적으로 ManyToMany관계에서는 3개의 테이블이 생성된다. -> CUSTOMER, PRODUCT, CUSTOMER_PRODUCT
     * 데이터를 집어 넣을 때는 CUSTOMER_PRODUCT 테이블은 신경쓰지 않아도 된다.
     */

}
