package com.example.hexagonal.board.application.service;

import com.example.hexagonal.board.application.port.in.BoardDto;
import com.example.hexagonal.board.application.port.in.BoardRequests.Create;
import com.example.hexagonal.board.application.port.in.WriteBoardUseCase;
import com.example.hexagonal.board.application.port.out.WriteBoardPort;
import com.example.hexagonal.board.domain.entity.Board;
import com.example.hexagonal.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class WriteBoardService implements WriteBoardUseCase {

    private final WriteBoardPort writeBoardPort;

    @Override
    public BoardDto create(Create request) {
        return BoardDto.from(writeBoardPort.create(Board.builder()
            .title(request.getTitle())
            .writer(request.getWriter())
            .content(request.getContent())
            .build()));
    }
}
