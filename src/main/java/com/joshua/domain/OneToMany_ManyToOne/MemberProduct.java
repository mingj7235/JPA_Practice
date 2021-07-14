package com.joshua.domain.OneToMany_ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(MemberProductId.class)
/**
 * @IdClass : JPA에서 복합 기본키를 매핑할 수 있게 해준다.
 * 이 어노테이션의 매개값으로 있는 MemberProductId.class는 식별자 클래스라고 한다.
 */

public class MemberProduct {
    /**
     * @id와 @JoinColumn을 동시에 사용해서 기본키 + 외래 키를 한번에 매핑하였다.
     */

    @Id
    @ManyToOne
    @JoinColumn (name = "MEMBER_ID")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn (name = "PRODUCT_ID")
    private Product product;

    private String columnTest;
}
