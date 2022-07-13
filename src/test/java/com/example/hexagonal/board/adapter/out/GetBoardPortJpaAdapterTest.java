package com.example.hexagonal.board.adapter.out;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.hexagonal.board.application.port.out.GetBoardPort;
import com.example.hexagonal.board.domain.entity.Board;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class GetBoardPortJpaAdapterTest {

    private static String TITLE = "제목";
    private static String WRITER = "작성자";
    private static String CONTENT = "본문";

    @InjectMocks
    private GetBoardPortJpaAdapter getBoardPortJpaAdapter;

    @Mock
    private BoardRepository boardRepository;

    @Test
    void findAll_test() {
        //given
        when(boardRepository.findAll()).thenReturn(List.of(generateBoard()));
        //when
        List<Board> boards = getBoardPortJpaAdapter.findAll();
        //then
        assertThat(boards.size()).isEqualTo(1);
    }

    @Test
    void find_by_id_값이_존재할_때() {
        //given
        when(boardRepository.findById(1L)).thenReturn(Optional.ofNullable(generateBoard()));
        //when
        Optional<Board> board = getBoardPortJpaAdapter.findById(1L);
        //then
        assertThat(board.isPresent()).isTrue();
    }

    @Test
    void find_by_id_값이_존재하지_않을_때() {
        //given
        when(boardRepository.findById(1L)).thenReturn(Optional.empty());
        //when
        Optional<Board> board = getBoardPortJpaAdapter.findById(1L);
        //then
        assertThat(board.isPresent()).isFalse();
    }

    private Board generateBoard() {
        Board board = Board.builder()
            .title(TITLE)
            .writer(WRITER)
            .content(CONTENT)
            .build();
        ReflectionTestUtils.setField(board,"id",1L);
        return board;
    }
}