package com.joshua.controller.boardPractice;

import com.joshua.dto.boardPractice.board.BoardSaveRequestDto;
import com.joshua.dto.boardPractice.board.BoardUpdateRequestDto;
import com.joshua.service.boardPractice.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardAPIController {

    private final BoardService boardService;

    @PostMapping ("/board/save")
    public void saveBoard (BoardSaveRequestDto requestDto) {
        boardService.saveBoard(requestDto);
    }

    @PostMapping ("/board/findReplyById/{id}")
    public void findReplyById (@PathVariable Long id) {
        boardService.findBoardById(id);
    }

    @PutMapping ("/board/update/{id}")
    public void updateBoard (@PathVariable Long id, BoardUpdateRequestDto requestDto) {
        boardService.updateBoard(id, requestDto);
    }

    @DeleteMapping ("/board/delete/{id}")
    public void deleteBoard (@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
