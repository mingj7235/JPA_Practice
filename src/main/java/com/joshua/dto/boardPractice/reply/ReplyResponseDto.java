package com.joshua.dto.boardPractice.reply;

import com.joshua.domain.boardPractice.Board;
import com.joshua.domain.boardPractice.Member;
import com.joshua.domain.boardPractice.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplyResponseDto {
    private String replyContent;
    private Board board;
    private Member member;

    public ReplyResponseDto (Reply entity) {
        this.replyContent = entity.getReplyContent();
        this.board = entity.getBoard();
        this.member = entity. getMember();
    }

}
