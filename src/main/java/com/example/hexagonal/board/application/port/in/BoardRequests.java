package com.example.hexagonal.board.application.port.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardRequests {

    @Getter
    @NoArgsConstructor
    public static class Create {
        private String title;
        private String content;
        private String writer;
    }

}
