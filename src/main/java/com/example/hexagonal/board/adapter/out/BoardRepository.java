package com.example.hexagonal.board.adapter.out;

import com.example.hexagonal.board.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
