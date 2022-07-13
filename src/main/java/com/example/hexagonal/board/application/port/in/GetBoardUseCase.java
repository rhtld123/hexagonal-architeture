package com.example.hexagonal.board.application.port.in;

import java.util.List;

public interface GetBoardUseCase {

    public List<BoardDto> findAll();

    public BoardDto findById(Long id);

}
