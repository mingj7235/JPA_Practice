package com.joshua.dto.boardPractice.board;

import com.joshua.domain.boardPractice.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String boardTitle;
    private String boardContent;

    public Board toEntity () {
        return Board.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .build();
    }
}
