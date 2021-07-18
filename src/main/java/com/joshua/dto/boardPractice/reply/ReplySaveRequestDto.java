package com.joshua.dto.boardPractice.reply;

import com.joshua.domain.boardPractice.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplySaveRequestDto {

    private String replyContent;
    private Long member_id;
    private Long board_id;

    public Reply toEntity () {
        return Reply.builder()
                .replyContent(replyContent)
                .build();
    }

}
