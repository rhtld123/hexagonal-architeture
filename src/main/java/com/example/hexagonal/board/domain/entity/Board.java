package com.example.hexagonal.board.domain.entity;

import com.example.hexagonal.common.domain.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Board extends BaseEntity {
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String writer;

    @Builder
    private Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
