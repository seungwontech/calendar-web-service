package com.goos.calendar.board;

import com.goos.calendar.apps.board.domain.model.dto.BoardInfo;
import com.goos.calendar.apps.board.domain.model.entity.Board;
import com.goos.calendar.apps.board.domain.model.enums.BoardStatus;
import com.goos.calendar.apps.board.infra.repository.BoardRepository;
import com.goos.calendar.apps.board.domain.service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;


    @Test
    public void testCreateBoard() {
        // Given
        LocalDateTime now = LocalDateTime.now();
        BoardInfo boardInfo = new BoardInfo(1L, "공지사항 제목", "공지사항 내용", "user123", "NOTICE", now, null);
        Board mockBoard = new Board(1L, "공지사항 제목", "공지사항 내용", "user123", BoardStatus.NOTICE, now, null);

        when(boardRepository.save(any(Board.class))).thenReturn(mockBoard);

        // When
        Board createdBoard = boardService.createBoard(boardInfo);

        // Then
        assertEquals("공지사항 제목", createdBoard.getTitle());
        assertEquals("공지사항 내용", createdBoard.getContent());
        assertEquals("user123", createdBoard.getMemberId());
        assertEquals(BoardStatus.NOTICE, createdBoard.getBoardStatus());
        assertEquals(now, createdBoard.getCreatedAt());

        verify(boardRepository, times(1)).save(any(Board.class));
    }
}
