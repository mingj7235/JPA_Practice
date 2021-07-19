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
    private Long boardId;
    private Long replyId;
    private String replyContent;
    private Long memberId;
    private String memberName;

    public ReplyResponseDto (Reply entity) {
        this.replyContent = entity.getReplyContent();
        this.boardId = entity.getBoard().getId();
        this.memberId = entity.getMember().getId();
        this.memberName = entity.getMember().getMemberName();
    }

}
