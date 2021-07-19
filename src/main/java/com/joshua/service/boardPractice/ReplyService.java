package com.joshua.service.boardPractice;

import com.joshua.domain.boardPractice.Reply;
import com.joshua.dto.boardPractice.reply.ReplyResponseDto;
import com.joshua.dto.boardPractice.reply.ReplySaveRequestDto;
import com.joshua.dto.boardPractice.reply.ReplyUpdateRequestDto;
import com.joshua.repository.boardPractice.BoardRepository;
import com.joshua.repository.boardPractice.MemberRepository;
import com.joshua.repository.boardPractice.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void saveReply (ReplySaveRequestDto requestDto) {
        Reply reply = requestDto.toEntity();
        reply.setBoard(boardRepository.findById(requestDto.getBoard_id())
                .orElseThrow(() -> new IllegalArgumentException("게시판 없슴")));
        reply.setMember(memberRepository.findById(requestDto.getMember_id())
                .orElseThrow(()-> new IllegalArgumentException("멤버 없슴")));
        replyRepository.save(reply);
    }

    public Long updateReply (Long id, ReplyUpdateRequestDto requestDto) {
        Reply reply = replyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 댓글이 없슴"));
        reply.setReplyContent(requestDto.getReplyContent());

        return replyRepository.save(reply).getId();
    }

    public void deleteReply (Long id) {
        Reply reply = replyRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("찾는 댓글이 없습"));
        replyRepository.delete(reply);
    }

    public ReplyResponseDto findReplyById (Long id) {
        Reply reply = replyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 없으요"));

        String memberName = reply.getMember().getMemberName();
        String boardTitle = reply.getBoard().getBoardTitle();
        String replyContent = reply.getReplyContent();

        System.out.println("게시판 : " + boardTitle + " 작성자 : " + memberName + " 댓글 : " + replyContent);
        return new ReplyResponseDto(reply);
    }
}
