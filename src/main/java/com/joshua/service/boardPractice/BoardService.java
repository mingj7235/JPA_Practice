package com.joshua.service.boardPractice;

import com.joshua.domain.boardPractice.Board;
import com.joshua.domain.boardPractice.Reply;
import com.joshua.dto.boardPractice.board.BoardResponseDto;
import com.joshua.dto.boardPractice.board.BoardSaveRequestDto;
import com.joshua.dto.boardPractice.board.BoardUpdateRequestDto;
import com.joshua.dto.boardPractice.page.PageDto;
import com.joshua.repository.boardPractice.BoardRepository;
import com.joshua.repository.boardPractice.MemberRepository;
import com.joshua.repository.boardPractice.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Long updateBoard (Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 게시판 없습니다."));
//        board.setId(1000L);
        board.setBoardTitle(requestDto.getBoardTitle());
        board.setBoardContent(requestDto.getBoardContent());

        return boardRepository.save(board).getId();
    }

    public void deleteBoard (Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("찾는 게시판 없슴"));
        boardRepository.delete(board);
    }

    public BoardResponseDto findReplyById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 게시판이없습니다."));

        System.out.println(board.getBoardTitle() + "의 댓글 목록 ");
        for (Reply reply : board.getReplies()) {
            System.out.println(reply.getReplyContent() + " / " + reply.getMember().getMemberName());
        }

        return new BoardResponseDto(board);
    }

    public Page<BoardResponseDto> getAllBoards (Pageable pageable) {
        return boardRepository.findAll(pageable)
                .map(BoardResponseDto::new);
    }
}
