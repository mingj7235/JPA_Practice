package com.joshua.controller.boardPractice;

import com.joshua.domain.boardPractice.Board;
import com.joshua.dto.boardPractice.board.BoardSaveRequestDto;
import com.joshua.dto.boardPractice.board.BoardUpdateRequestDto;
import com.joshua.repository.boardPractice.BoardRepository;
import com.joshua.service.boardPractice.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collector;

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

    @GetMapping ("/board")
    public Page<Board> getPage (Pageable pageable) {
        Page<Board> allBoards = boardService.getAllBoards(pageable);

//        int totalPage = allBoards.getTotalPages();
//
//        //페이지에 있는 전체 게시판을 불러오려면...?
//
//        Board board = allBoards.get().findAny()
//                .orElseThrow(() -> new IllegalArgumentException("게시판 없슴"));
//        //이건 param으로 받은 페이지의 첫번째 게시판의 이름이고..
//        String boardTitle = board.getBoardTitle();
//        Long boardId = board.getId();
//
//        String result = "";

        return allBoards;
    }
}
