package com.joshua.dto.boardPractice.board;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.joshua.domain.boardPractice.Board;
import com.joshua.domain.boardPractice.Member;
import com.joshua.domain.boardPractice.Reply;
import com.joshua.dto.boardPractice.reply.ReplyResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {
    private String boardTitle;
    private String boardContent;
    private Member member;

//    @JsonManagedReference
    private List<ReplyResponseDto> replies;

    public BoardResponseDto (Board entity) {
        this.boardTitle = entity.getBoardTitle();
        this.boardContent = entity.getBoardContent();
        this.member = entity.getMember();
        this.replies =entity.getReplies().stream()
                .map(ReplyResponseDto::new).collect(Collectors.toList());
    }
}
