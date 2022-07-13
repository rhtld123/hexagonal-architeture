package com.example.hexagonal.board.application.service;

import com.example.hexagonal.board.application.port.in.BoardDto;
import com.example.hexagonal.board.application.port.in.GetBoardUseCase;
import com.example.hexagonal.board.application.port.out.GetBoardPort;
import com.example.hexagonal.board.domain.entity.Board;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetBoardService implements GetBoardUseCase {

    private final GetBoardPort getBoardPort;

    @Override
    public List<BoardDto> findAll() {
        return getBoardPort.findAll()
            .stream()
            .map(BoardDto::from)
            .collect(Collectors.toList());
    }

    @Override
    public BoardDto findById(Long id) {
        Board board = getBoardPort.findById(id)
            .orElseThrow(() -> new NotFoundEntityException("해당 게시글이 존재하지 않습니다."));
        return BoardDto.from(board);
    }
}
