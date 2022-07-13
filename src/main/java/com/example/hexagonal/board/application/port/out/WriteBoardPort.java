package com.example.hexagonal.board.application.port.out;

import com.example.hexagonal.board.domain.entity.Board;

public interface WriteBoardPort {
    public Board create(Board board);
}
