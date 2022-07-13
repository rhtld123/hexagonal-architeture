package com.example.hexagonal.board.application.port.out;

import com.example.hexagonal.board.domain.entity.Board;
import java.util.List;
import java.util.Optional;

public interface GetBoardPort {

    public List<Board> findAll();

    public Optional<Board> findById(Long id);

}
