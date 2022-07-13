package com.example.hexagonal.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.hexagonal.board.domain.entity.Board;
import org.junit.jupiter.api.Test;

class BoardEntityTest {

    private static String TITLE = "글제목";
    private static String WRITER = "작성자";
    private static String CONTENT = "본문";
    @Test
    void create_entity_test() {
        Board board = Board.builder()
            .title(TITLE)
            .writer(WRITER)
            .content(CONTENT)
            .build();

        assertThat(board.getTitle()).isEqualTo(TITLE);
        assertThat(board.getWriter()).isEqualTo(WRITER);
        assertThat(board.getContent()).isEqualTo(CONTENT);

    }
}
