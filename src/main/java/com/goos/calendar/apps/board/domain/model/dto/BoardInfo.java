package com.goos.calendar.apps.board.domain.model.dto;


import com.goos.calendar.apps.board.domain.model.entity.Board;
import com.goos.calendar.apps.board.domain.model.enums.BoardStatus;

import java.time.LocalDateTime;

public record BoardInfo(
        Long id
        , String title
        , String content
        , String memberId
        , String boardStatus
        , LocalDateTime createdAt
        , LocalDateTime updatedAt) {

    public static BoardInfo from(Board board) {
        return new BoardInfo(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getMemberId(),
                board.getBoardStatus().name(),
                board.getCreatedAt(),
                board.getUpdatedAt()
        );
    }
}