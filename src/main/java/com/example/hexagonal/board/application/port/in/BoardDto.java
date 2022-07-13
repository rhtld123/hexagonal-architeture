package com.example.hexagonal.board.application.port.in;

import com.example.hexagonal.board.domain.entity.Board;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isDeleted;

    @Builder
    private BoardDto(Long id, String title, String content, String writer,
        LocalDateTime createdAt, LocalDateTime updatedAt, boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
    }

    public static BoardDto from(Board board) {
        return BoardDto.builder()
            .id(board.getId())
            .title(board.getTitle())
            .content(board.getContent())
            .writer(board.getWriter())
            .createdAt(board.getCreatedAt())
            .updatedAt(board.getUpdatedAt())
            .isDeleted(hasDeletedAt(board.getDeletedAt()))
            .build();
    }

    private static boolean hasDeletedAt(LocalDateTime deletedAt) {
        return deletedAt != null ? true : false;
    }
}
