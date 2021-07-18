package com.joshua.dto.boardPractice.board;

import com.joshua.domain.boardPractice.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String boardTitle;
    private String boardContent;
    private Long member_id;

    public Board toEntity () {
        return Board.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .build();
    }
}
