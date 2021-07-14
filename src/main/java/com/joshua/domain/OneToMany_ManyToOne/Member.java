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
public class Member {
    /**
     * @ManyToMany의 한계
     * @ManyToMany를 사용하면 중간 연결 테이블 (CUSTOMER_PRODUCT)를 자동으로 관리하고 생성해주므로 편리함
     * 하지만 일반적으로 실무에서는 연결테이블에 외래키만 담지않고 추가적인 칼럼이 들어가게된다.
     * 이 연결 테이블에 추가적인 칼럼이 들어갈 경우 @ManyToMany는 더이상 사용할 수 없다.
     * 그렇기 때문에 직접 새로운 연결 엔티티(MemberProduct)를 만들어서 @OneToMany, @ManyToOne관계를 해줘야한다.
     *
     * Member, Product 엔터티에서는 MemberProduct 엔터티와 일대다로 관계를 맺는다.
     */
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String memberName;

    @OneToMany(mappedBy = "members")
    private List<MemberProduct> memberProducts = new ArrayList<>();

}
