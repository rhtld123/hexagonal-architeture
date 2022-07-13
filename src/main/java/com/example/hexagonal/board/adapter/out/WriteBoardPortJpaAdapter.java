package com.example.hexagonal.board.adapter.out;

import com.example.hexagonal.board.application.port.out.WriteBoardPort;
import com.example.hexagonal.board.domain.entity.Board;
import com.example.hexagonal.common.WriteDatabaseAdapter;
import lombok.RequiredArgsConstructor;

@WriteDatabaseAdapter
@RequiredArgsConstructor
public class WriteBoardPortJpaAdapter implements WriteBoardPort {

    private final BoardRepository boardRepository;

    @Override
    public Board create(Board board) {
        return boardRepository.save(board);
    }
}
