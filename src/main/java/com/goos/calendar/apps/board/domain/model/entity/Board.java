package com.goos.calendar.apps.board.domain.model.entity;

import com.goos.calendar.apps.board.domain.model.enums.BoardStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "member_id", nullable = false, length = 50)
    private String memberId;

    @Enumerated(EnumType.STRING)
    @Column(name = "board_status", nullable = false)
    private BoardStatus boardStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public static Board create(String title, String content, String memberId, BoardStatus boardType) {
        return new Board(null, title, content, memberId, boardType, LocalDateTime.now(), null);
    }

}
