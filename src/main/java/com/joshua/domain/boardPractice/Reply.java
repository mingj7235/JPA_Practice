package com.joshua.domain.boardPractice;

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

    @ManyToOne
    @JoinColumn (name = "BOARD_ID")
    private Board board;

    @ManyToOne
    @JoinColumn (name = "MEMBER_ID")
    private Member member;

}
