package com.goos.calendar.apps.board.infra.repository;

import com.goos.calendar.apps.board.domain.model.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
