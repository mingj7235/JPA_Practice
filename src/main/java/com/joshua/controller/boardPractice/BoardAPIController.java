package com.joshua.controller.boardPractice;

import com.joshua.dto.boardPractice.board.BoardSaveRequestDto;
import com.joshua.service.boardPractice.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardAPIController {

    private final BoardService boardService;

    @PostMapping ("/board/save")
    public void saveBoard (BoardSaveRequestDto requestDto) {
        boardService.saveBoard(requestDto);
    }
}
