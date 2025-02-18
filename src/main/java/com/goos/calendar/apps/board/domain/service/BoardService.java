package com.goos.calendar.apps.board.domain.service;

import com.goos.calendar.apps.board.domain.model.dto.BoardInfo;
import com.goos.calendar.apps.board.domain.model.entity.Board;
import com.goos.calendar.apps.board.domain.model.enums.BoardStatus;
import com.goos.calendar.apps.board.infra.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Board createBoard(BoardInfo boardInfo) {
        Board board = Board.create(boardInfo.title(),boardInfo.content(),boardInfo.memberId(), BoardStatus.valueOf(boardInfo.boardStatus()));
        return boardRepository.save(board);
    }
}
