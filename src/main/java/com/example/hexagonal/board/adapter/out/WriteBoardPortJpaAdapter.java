package com.example.hexagonal.board.adapter.out;

import com.example.hexagonal.board.application.port.out.WriteBoardPort;
import com.example.hexagonal.board.domain.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class WriteBoardPortJpaAdapter implements WriteBoardPort {

    private final BoardRepository boardRepository;

    @Override
    public Board create(Board board) {
        return boardRepository.save(board);
    }
}
