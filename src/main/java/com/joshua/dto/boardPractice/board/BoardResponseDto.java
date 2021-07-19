package com.joshua.dto.boardPractice.board;

import com.joshua.domain.boardPractice.Board;
import com.joshua.domain.boardPractice.Member;
import com.joshua.domain.boardPractice.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {
    private String boardTitle;
    private String boardContent;
    private Member member;
    private List<Reply> replies;

    public BoardResponseDto (Board entity) {
        this.boardTitle = entity.getBoardTitle();
        this.boardContent = entity.getBoardContent();
//        this.member = entity.getMember();
//        this.replies =entity.getReplies();
    }
}
