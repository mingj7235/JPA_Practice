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
public class Board {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardTitle;

    private String boardContent;

    @ManyToOne
    @JoinColumn (name = "MEMBER_ID")
    private Member member;

    @OneToMany (mappedBy = "board")
    private List<Reply> replies;

    @Builder
    public Board(String boardTitle, String boardContent, Member member, List<Reply> replies) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.member = member;
        this.replies = replies;
    }
}
