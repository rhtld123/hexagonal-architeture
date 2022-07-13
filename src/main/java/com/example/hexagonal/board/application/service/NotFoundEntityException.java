package com.example.hexagonal.board.application.service;

public class NotFoundEntityException extends RuntimeException{

    public NotFoundEntityException(String message) {
        super(message);
    }
}
