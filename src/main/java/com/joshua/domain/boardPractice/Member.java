package com.joshua.domain.boardPractice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;
    private Integer memberAge;

    @OneToMany (mappedBy = "member")
    private List<Board> boards;

    @OneToMany (mappedBy = "member")
    private List<Reply> replies;

    @Builder
    public Member(String memberName, Integer memberAge, List<Board> boards, List<Reply> replies) {
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.boards = boards;
        this.replies = replies;
    }
}
