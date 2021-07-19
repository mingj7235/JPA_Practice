package com.joshua.domain.boardPractice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reply {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String replyContent;

    //@JsonBackReference
    //@JsonManagedReference
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "BOARD_ID")
    private Board board;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "MEMBER_ID")
    private Member member;

    @Builder
    public Reply(String replyContent, Board board, Member member) {
        this.replyContent = replyContent;
        this.board = board;
        this.member = member;
    }
}
