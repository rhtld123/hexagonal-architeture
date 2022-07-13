package com.example.hexagonal.board.adapter.in.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.hexagonal.board.application.port.in.BoardDto;
import com.example.hexagonal.board.application.port.in.BoardRequests;
import com.example.hexagonal.board.application.port.in.GetBoardUseCase;
import com.example.hexagonal.board.application.port.in.WriteBoardUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardAdapter {

    private final GetBoardUseCase getBoardUseCase;
    private final WriteBoardUseCase writeBoardUseCase;

    @GetMapping(value = "/api/v1/boards", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BoardDto> findAll() {
        return getBoardUseCase.findAll();
    }

    @GetMapping(value = "/api/v1/boards/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BoardDto findById(@PathVariable("id") Long id) {
        return getBoardUseCase.findById(id);
    }

    @PostMapping(value = "/api/v1/boards", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BoardDto save(@RequestBody BoardRequests.Create request) {
        return writeBoardUseCase.create(request);
    }

}
