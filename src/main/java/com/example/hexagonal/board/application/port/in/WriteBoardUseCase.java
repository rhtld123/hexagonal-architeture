package com.example.hexagonal.board.application.port.in;

public interface WriteBoardUseCase {
    public BoardDto create(BoardRequests.Create request);
}
