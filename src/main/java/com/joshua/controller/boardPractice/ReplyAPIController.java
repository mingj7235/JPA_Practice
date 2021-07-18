package com.joshua.controller.boardPractice;

import com.joshua.dto.boardPractice.reply.ReplyResponseDto;
import com.joshua.dto.boardPractice.reply.ReplySaveRequestDto;
import com.joshua.service.boardPractice.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
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


}
