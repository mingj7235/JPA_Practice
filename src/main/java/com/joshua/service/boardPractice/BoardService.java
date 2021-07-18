package com.joshua.service.boardPractice;

import com.joshua.domain.boardPractice.Board;
import com.joshua.domain.boardPractice.Reply;
import com.joshua.dto.boardPractice.board.BoardResponseDto;
import com.joshua.dto.boardPractice.board.BoardSaveRequestDto;
import com.joshua.repository.boardPractice.BoardRepository;
import com.joshua.repository.boardPractice.MemberRepository;
import com.joshua.repository.boardPractice.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public Long saveBoard (BoardSaveRequestDto requestDto) {
        Board board = requestDto.toEntity();
        board.setMember(memberRepository.findById(requestDto.getMember_id())
                .orElseThrow(()-> new IllegalArgumentException("찾는 멤버가 없슴")));

        return boardRepository.save(board).getId();
    }

    public BoardResponseDto findBoardById (Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 게시판이없습니다."));

        for (Reply reply : board.getReplies()) {
            System.out.println(reply.getReplyContent());
        }

        return new BoardResponseDto(board);
    }
}
