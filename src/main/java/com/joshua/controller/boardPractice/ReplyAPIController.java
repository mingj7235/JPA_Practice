package com.joshua.controller.boardPractice;

import com.joshua.dto.boardPractice.reply.ReplyResponseDto;
import com.joshua.dto.boardPractice.reply.ReplySaveRequestDto;
import com.joshua.dto.boardPractice.reply.ReplyUpdateRequestDto;
import com.joshua.service.boardPractice.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReplyAPIController {
    private final ReplyService replyService;

    @PostMapping ("/reply/save")
    public void saveReply (ReplySaveRequestDto requestDto) {
        replyService.saveReply(requestDto);
    }

    @PostMapping ("/reply/find/{id}")
    public void findReplyById (@PathVariable Long id) {
        ReplyResponseDto replyById = replyService.findReplyById(id);
    }

    @PutMapping ("/reply/update/{id}")
    public void updateReply (@PathVariable Long id, ReplyUpdateRequestDto requestDto) {
        replyService.updateReply(id, requestDto);
    }

    @DeleteMapping ("/reply/delete/{id}")
    public void deleteReply (@PathVariable Long id) {
        replyService.deleteReply(id);
    }


}
