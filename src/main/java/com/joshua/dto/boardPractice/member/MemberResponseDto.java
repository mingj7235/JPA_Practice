package com.joshua.dto.boardPractice.member;

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
public class MemberResponseDto {
    private String memberName;
    private Integer memberAge;
    private List<Board> boards;
    private List<Reply> replies;

    public MemberResponseDto (Member entity) {
        this.memberName = entity.getMemberName();
        this.memberAge = entity.getMemberAge();
        this.boards = entity.getBoards();
        this.replies = entity.getReplies();

    }
}
