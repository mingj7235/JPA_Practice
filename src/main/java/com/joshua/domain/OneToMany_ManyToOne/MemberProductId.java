package com.joshua.domain.OneToMany_ManyToOne;

import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 식별자 클래스. 식별자 클래스를 만들 때는 다음 특징을 만족해야한다.
 * 1. Serializable을 implements 해야한다.
 * 2. 식별자 클래스의 속성명과 엔티티에서 사용하는 식별자 속성명은 같아야한다. (member, product)
 *      즉, 엔터티의 클래스명과, 식별자 클래스의 필드명과 같아야한다.
 * 3. equals, hashCode 메소드를 구현해야한다.
 * 4. 기본생성자가 있어햐한다.
 * 5. 식별자 클래스는 public이어야한다.
 */

@NoArgsConstructor
public class MemberProductId implements Serializable {
    private Long member;
    private Long product;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
