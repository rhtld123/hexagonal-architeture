package com.example.hexagonal.board.adapter.out;

import com.example.hexagonal.board.application.port.out.GetBoardPort;
import com.example.hexagonal.board.domain.entity.Board;
import com.example.hexagonal.common.ReadDatabaseAdapter;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@ReadDatabaseAdapter
@RequiredArgsConstructor
public class GetBoardPortJpaAdapter implements GetBoardPort {

    private final BoardRepository boardRepository;

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }
}
